/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author DELL
 */
public class hh {
    static double pInit;
    static double pHill1;
    static double pHill2;
    static double pTabu1;
    static double pTabu2;
    
    
    public static void main(String[] args) {
        String stu = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\sta-f-83.stu";
        String crs = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\sta-f-83.crs";
        timeTabling(crs, stu);
        System.out.println("done");
        System.out.println("Initial Penalty : "+pInit);
        System.out.println("HC penalty : "+ pHill1);
        System.out.println("TS Penalty : "+ pTabu1);
    }
    public static void timeTabling(String crs, String stu) {
        ArrayList<String> course; 
        //ArrayList<String> scourse;
        ArrayList<String> student;
        int[][] conflict_matrix;
        try {
            
            FileReader fcr = new FileReader(crs);
            BufferedReader cr = new BufferedReader(fcr);
            
            FileReader fst = new FileReader(stu);
            BufferedReader st = new BufferedReader(fst);
            
            
            course = new ArrayList<String>();
            //scourse = new ArrayList<String>();
            String courseLine = null;
            while((courseLine = cr.readLine()) != null) {
                    String[] arr = courseLine.split(" ");
                    course.add(arr[0]);
                    //scourse.add(arr[0]);
            }
            
            student = new ArrayList<String>();
            conflict_matrix = new int[course.size()][course.size()];
            
            String StudentLine = null;
            while((StudentLine = st.readLine()) != null) {
                String[] arr = StudentLine.split(" ");
                
                if(arr.length > 0) {
                    for(int i = 0; i < arr.length-1; i++) {
                        for(int j = i+1; j < arr.length; j++) {
                            int index1 = Integer.parseInt(arr[i]);
                            int index2 = Integer.parseInt(arr[j]);
                            
                            conflict_matrix[index1-1][index2-1]=1;
                            conflict_matrix[index2-1][index1-1]=1;
                        }
                    }
                }
                student.add(arr[0]);
            }
            
            int[][]degrees = new int[course.size()][2];
            for(int i=0;i<degrees.length;i++){
                degrees[i][0]=i+1;
            }
            
            int sum = 0;
            for(int i = 0; i < conflict_matrix.length; i++) {
                for(int j = 0; j < conflict_matrix.length; j++) {
                    
                    if(conflict_matrix[i][j] != 0){
                        sum++;
                    }
                }
                degrees[i][1]=sum;
                sum=0;
            }
            
//            System.out.println("------unsorted------");
//            for(int i = 0; i <degrees.length;i++){
//                System.out.println(i + "" + Arrays.toString(degrees[i]));
//            }
            
            int[][]sort_degrees = new int[course.size()][3];    
            sort_degrees=degrees;
           
            
            Arrays.sort(sort_degrees, new Comparator<int[]>() { 
		@Override
		public int compare(int[] entry1, int[] entry2) { 
                    if (entry1[1] < entry2[1]) 
                        return 1; 
                    else
                        return -1; 
                  } 
                });
            
//            System.out.println("------sorted------");
//            for(int i = 0; i <sort_degrees.length;i++){
//                System.out.println(i + "" + Arrays.toString(sort_degrees[i]));
//            }
            int ts=1;
            int [][] timeslot = new int[course.size()][2];
            
            for(int i=0; i<sort_degrees.length; i++){
                for(int j=0; j<ts; j++){
                    if(check(i, j, conflict_matrix, sort_degrees, timeslot)){
                            timeslot[sort_degrees[i][0]-1][0] = i;
                            timeslot[sort_degrees[i][0]-1][1] = j;
                            break;
                    }else{
                            ts++;
                    }
                }
            }
//            for(int i = 0; i < timeslot.length; i++){
//                System.out.println(Arrays.toString(timeslot[i]));
//            }
            
            double penalty = 0;
            pInit = penalty(conflict_matrix,timeslot,student.size());
            System.out.println("penalty : " + penalty);
            
            int max_timeslot = 0;
            
            for(int i = 0; i<timeslot.length; i++) {
                if(timeslot[i][1] > max_timeslot)
                        max_timeslot = timeslot[i][1];
            }
//            hillClimb(conflict_matrix, timeslot, ts, sum, ts);
            int tsHillClimb[][]=hillClimb(conflict_matrix, timeslot, student.size(), course.size(), max_timeslot);
//            tabus(timeslot, conflict_matrix, course, student, max_timeslot);
            for(int i = 0; i < timeslot.length; i++){
                System.out.println(Arrays.toString(tsHillClimb[i]));
            }
            
            
        }
        catch(Exception e) {
            System.out.println("error: " + e);
            e.printStackTrace();
        }
    }
    
    public static int[][] tabus(int[][]timeslot, int[][]conflict_matrix , ArrayList<String> course, ArrayList<String> student, int max_timeslot) {
            
            double in_penalty = 0;
            in_penalty = penalty(conflict_matrix,timeslot,student.size());
            
            Random r = new Random();

            int rindex1,rindex2,rindex3 = 0;
            int rslot1,rslot2,rslot3 = 0;
            
            int[][]sbest = timeslot.clone();
            int[][]bestcandidate = timeslot.clone();
            int[][]timeslot1 = timeslot.clone();
            
            LinkedList<int[][]> tabulist = new LinkedList<int[][]>();
            int maxtabusize = 10;
            tabulist.addLast(timeslot.clone());
            
            int ts_it = 10000;
            int iteration=0;
            
            double penalty1 = 0;
            double penalty2 = 0;
            double penalty3 = 0;
            
            boolean terminate = false;
            long starttimer = System.nanoTime();
            while(iteration < ts_it ){
                iteration++;
                

                ArrayList<int[][]> sneighborhood = new ArrayList<>();


                //move 1
                rindex1 = r.nextInt(course.size());
                rslot1 = r.nextInt(max_timeslot);
                if (check2(rindex1, rslot1, conflict_matrix, timeslot1)) {
                    timeslot1[rindex1][1] = rslot1;
                }
                sneighborhood.add(timeslot1);

                //move 2
                rindex1 = r.nextInt(course.size());
                rslot1 = r.nextInt(max_timeslot);
                rindex2 = r.nextInt(course.size());
                rslot2 = r.nextInt(max_timeslot);
                if (check2(rindex1, rslot1, conflict_matrix, timeslot1)) {
                    timeslot1[rindex1][1] = rslot1;
                }
                if (check2(rindex2, rslot2, conflict_matrix, timeslot1)) {
                    timeslot1[rindex2][1] = rslot2;
                }
                sneighborhood.add(timeslot1);


                rindex1 = r.nextInt(course.size());
                rslot1 = r.nextInt(max_timeslot);
                rindex2 = r.nextInt(course.size());
                rslot2 = r.nextInt(max_timeslot);
                rindex3 = r.nextInt(course.size());
                rslot3 = r.nextInt(max_timeslot);
                if (check2(rindex1, rslot1, conflict_matrix, timeslot1)) {
                    timeslot1[rindex1][1] = rslot1;
                }
                if (check2(rindex2, rslot2, conflict_matrix, timeslot1)) {
                    timeslot1[rindex2][1] = rslot2;
                }
                if (check2(rindex3, rslot3, conflict_matrix, timeslot1)) {
                    timeslot1[rindex3][1] = rslot3;
                }
                sneighborhood.add(timeslot1);




                do{
                    rindex1 = r.nextInt(course.size());
                    rindex2 = r.nextInt(course.size());
                }while(rindex1==rindex2);
                rslot1 = timeslot1[rindex1][1];
                rslot2 = timeslot1[rindex2][1];
                if (check2(rindex1, rslot2, conflict_matrix, timeslot1)) {
                    timeslot1[rindex1][1]=rslot2;
                }
                if (check2(rindex2, rslot1, conflict_matrix, timeslot1)) {
                    timeslot1[rindex2][1]=rslot1;
                }
                sneighborhood.add(timeslot1);


                 do{
                    rindex1 = r.nextInt(course.size());
                    rindex2 = r.nextInt(course.size());
                    rindex3 = r.nextInt(course.size());
                }while(rindex1==rindex2||rindex1==rindex3||rindex2==rindex3);
                rslot1 = timeslot1[rindex1][1];
                rslot2 = timeslot1[rindex2][1];
                rslot3 = timeslot1[rindex3][1];
                if (check2(rindex1, rslot2, conflict_matrix, timeslot1)) {
                    timeslot1[rindex1][1]=rslot2;
                }
                if (check2(rindex2, rslot3, conflict_matrix, timeslot1)) {
                    timeslot1[rindex2][1]=rslot3;
                }
                if (check2(rindex3, rslot1, conflict_matrix, timeslot1)) {
                    timeslot1[rindex3][1]=rslot1;
                }
                sneighborhood.add(timeslot1);
//                    System.out.println(sneighborhood.size());

                int j = 0;
                while (sneighborhood.size() > j) {
                    penalty2 = penalty(conflict_matrix, sneighborhood.get(j), student.size());
                    penalty1 = penalty(conflict_matrix, bestcandidate, student.size());
                    if(!(tabulist.contains(sneighborhood.get(j))) && penalty2<penalty1){
                        bestcandidate = sneighborhood.get(j);
                    }
                        j++;
                }

                sneighborhood.clear();

                if(penalty(conflict_matrix, bestcandidate, student.size()) < penalty(conflict_matrix, sbest, student.size())){
                    sbest = bestcandidate;
                }
                tabulist.addLast(bestcandidate);
                if(tabulist.size() > maxtabusize){
                    tabulist.removeFirst();
                }
                    //return sbest;
                    
//                System.out.println("iteration "+iteration+" penalty "+ penalty(conflict_matrix, sbest, student.size()));

            }
            long endtimer   = System.nanoTime();
            long totaltimer = endtimer - starttimer;
            
            
            penalty3 = penalty(conflict_matrix, sbest, student.size());
            
            //hillclimbing(conflict_matrix, timeslot, student.size(), course.size(), max_timeslot);
            
            System.out.println("time : " + (double)totaltimer/1000000000 + " detik");
            
            System.out.println("initial penalty: "+ in_penalty);
            System.out.println("tabu search penalty: "+ penalty3);
            
        return sbest;
    }
    
    public static double penalty(int[][]conflict_matrix,int[][]timeslot,int student) {
        double penalty = 0;
        for(int i=0;i<conflict_matrix.length-1;i++){
                for(int j=i+1;j<conflict_matrix.length;j++){
                    if(conflict_matrix[i][j]!=0){
                        if(Math.abs(timeslot[j][1]-timeslot[i][1])>=1 && Math.abs(timeslot[j][1]-timeslot[i][1])<=5){
                            penalty = (penalty + conflict_matrix[i][j]*(Math.pow(2, (5-(Math.abs(timeslot[j][1]-timeslot[i][1]))))));
                        }
                    }
                }
            }
        return penalty/student;
    }
    public static boolean check(int index, int ntimeslot, int conf[][], int[][]sort_degrees, int[][]timeslot) {
        for(int i=0; i<sort_degrees.length;i++)
		if(conf[sort_degrees[index][0]-1][i]!=0 && timeslot[i][1] == ntimeslot)
                    return false;
        return true;
    }
    
    public static boolean check2(int indexcourse, int ntimeslot, int conf[][], int[][]timeslot){
	for(int i=0; i<conf.length;i++)
		if(conf[indexcourse][i]!=0 && timeslot[i][1] == ntimeslot)
                    return false;
        return true;
    }
    
    public static int[][] hillClimb(int conf[][], int[][]timeslot, int stu, int cour, int max) {
        Random r = new Random();
        int ran_exam=0;
        int ran_slot=0;
        int timeslotH1[][]=timeslot.clone();
        int timeslotH2[][]=timeslot.clone();
        pHill1 = pInit;
        int n_it = 1000;
        for (int i = 0; i < n_it; i++) {
            ran_exam=r.nextInt(cour);
            ran_slot=r.nextInt(max);

            if(check2(ran_exam, ran_slot, conf, timeslotH1)) {
                timeslotH2[ran_exam][1] = ran_slot;
                pHill2 = 0;
                pHill2 = penalty(conf, timeslotH2, stu);
                if(pHill2 < pHill1){
                    pHill1 = pHill2;
                    timeslotH1[ran_exam][1] = timeslotH2[ran_exam][1];
                }else{
                    timeslotH2[ran_exam][1] = timeslotH1[ran_exam][1];
                }
            }
            System.out.println("iterasi "+(i+1)+" penalty "+ pHill1);
        }
        return timeslotH2;
        
    }
    
    public static void vns(int[][]timeslot, int[][]conflict_matrix , ArrayList<String> course, ArrayList<String> student, int max_timeslot) {
        double in_penalty = 0;
        in_penalty = penalty(conflict_matrix,timeslot,student.size());
        
        Random r = new Random();
        
        int rindex1,rindex2,rindex3 = 0;
        int rslot1,rslot2,rslot3 = 0;
        
        
        
    }
    
}
