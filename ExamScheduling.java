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
import java.util.Scanner;
import org.graalvm.compiler.nodes.BreakpointNode;

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
    static double pVNS;
    static long hctime;
    static long tstime;
    static int [][] sch1;
    static int [][] schHC;
    static int [][] schTS;
    static int [][] schVNS;
    static int nslot;
    static int method;
    
    public static void main(String[] args) {
        String carf92_crs = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\car-f-92.crs";
        String carf92_stu = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\car-f-92.stu";

        String cars91_crs = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\car-s-91.crs";
        String cars91_stu = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\car-s-91.stu";

        String earf83_crs = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\ear-f-83.crs";
        String earf83_stu = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\ear-f-83.stu";

        String hecs92_crs = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\hec-s-92.crs";
        String hecs92_stu = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\hec-s-92.stu";

        String kfus93_crs = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\kfu-s-93.crs";
        String kfus93_stu = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\kfu-s-93.stu";

        String lsef91_crs = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\lse-f-91.crs";
        String lsef91_stu = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\lse-f-91.stu";

        String purs93_crs = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\pur-s-93.crs";
        String purs93_stu = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\pur-s-93.stu";

        String ryes93_crs = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\rye-s-93.crs";
        String ryes93_stu = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\rye-s-93.stu";

        String staf83_crs = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\sta-f-83.crs";
        String staf83_stu = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\sta-f-83.stu";

        String tres92_crs = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\tre-s-92.crs";
        String tres92_stu = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\tre-s-92.stu";

        String utas92_crs = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\uta-s-92.crs";
        String utas92_stu = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\uta-s-92.stu";

        String utes92_crs = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\ute-s-92.crs";
        String utes92_stu = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\ute-s-92.stu";

        String yorf83_crs = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\yor-f-83.crs";
        String yorf83_stu = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\yor-f-83.stu";
        
        Scanner in = new Scanner(System.in);
        System.out.println("Choose : ");
        System.out.println("1. car-f-92");
        System.out.println("2. car-s-91");
        System.out.println("3. ear-f-83");
        System.out.println("4. hec-s-92");
        System.out.println("5. kfu-s-93");
        System.out.println("6. lse-f-91");
        System.out.println("7. pur-s-93");
        System.out.println("8. rye-s-93");
        System.out.println("9. sta-f-83");
        System.out.println("10. tre-s-92");
        System.out.println("11. uta-s-92");
        System.out.println("12. ute-s-92");
        System.out.println("13. yot-f-83");
        System.out.println("0. Exit");

        System.out.println("choice : ");
        int input = in.nextInt();
        
        System.out.println("1. Hill Climbing");
        System.out.println("2. Tabu Search");
        System.out.println("3. Both");
        System.out.println("4. VNS");
        System.out.println("choose method : ");
        method = in.nextInt();

        switch(input) {
            case 1 :
                timeTabling(carf92_crs, carf92_stu);
                break;
            case 2 :
                timeTabling(cars91_crs, cars91_stu);
                break;
            case 3 :
                timeTabling(earf83_crs, earf83_stu);
                break;
            case 4 :
                timeTabling(hecs92_crs, hecs92_stu);
                break;
            case 5 :
                timeTabling(kfus93_crs, kfus93_stu);
                break;
            case 6 :
                timeTabling(lsef91_crs, lsef91_stu);
                break;
            case 7 :
                timeTabling(purs93_crs, purs93_stu);
                break;
            case 8 :
                timeTabling(ryes93_crs, ryes93_stu);
                break;
            case 9 :
                timeTabling(staf83_crs, staf83_stu);
                break;
            case 10 :
                timeTabling(tres92_crs, tres92_stu);
                break;
            case 11 :
                timeTabling(utas92_crs, utas92_stu);
                break;
            case 12 :
                timeTabling(utes92_crs, utes92_stu);
                break;
            case 13 :
                timeTabling(yorf83_crs, yorf83_stu);
                break;

            case 0 :
                System.out.println("exit");
                break;
            default :
                break;
            }

            in.close();
        

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
                            
                            conflict_matrix[index1-1][index2-1]++;
                            conflict_matrix[index2-1][index1-1]++;
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
            System.out.println("penalty : " + pInit);
            
            
            
            int max_timeslot = 0;
            
            for(int i = 0; i<timeslot.length; i++) {
                if(timeslot[i][1] > max_timeslot)
                        max_timeslot = timeslot[i][1];
            }
            nslot = max_timeslot;
            System.out.println(nslot);
//            hillClimb(conflict_matrix, timeslot, ts, sum, ts);
            if(method == 1){
                int tsHillClimb[][]=hillClimb(conflict_matrix, timeslot, student.size(), course.size(), max_timeslot);
                System.out.println("done");
                System.out.println("number of timeslot : "+nslot);
                System.out.println("Initial Penalty : "+pInit);
                System.out.println("HC penalty : "+ pHill1);
                System.out.println("HC Delta  : " + delta(pInit, pHill1));
                System.out.println("HC time : " + hctime);
            } else if(method == 2){
                int tsTabus[][]= tabus(timeslot, conflict_matrix, course, student, max_timeslot);
                System.out.println("done");
                System.out.println("number of timeslot : "+nslot);
                System.out.println("Initial Penalty : "+pInit);
                System.out.println("TS Penalty : "+ pTabu1);
                System.out.println("TS Delta  : " + delta(pInit, pTabu1));
                System.out.println("TS time : " + tstime);
            } else if(method == 3) {
                int tsHillClimb[][]=hillClimb(conflict_matrix, timeslot, student.size(), course.size(), max_timeslot);
                int tsTabus[][]= tabus(timeslot, conflict_matrix, course, student, max_timeslot);
                System.out.println("done");
                System.out.println("number of timeslot : "+nslot);
                System.out.println("Initial Penalty : "+pInit);
                System.out.println("HC penalty : "+ pHill1);
                System.out.println("HC Delta  : " + delta(pInit, pHill1));
                System.out.println("HC time : " + hctime);
                System.out.println("TS Penalty : "+ pTabu1);
                System.out.println("TS Delta  : " + delta(pInit, pTabu1));
                System.out.println("TS time : " + tstime);
            } else if(method == 4) {
                int tsvns[][]=vns(timeslot, conflict_matrix, course, student, max_timeslot);
                System.out.println("done");
                System.out.println("number of timeslot : "+nslot);
                System.out.println("Initial Penalty : "+pInit);
                System.out.println("VNS Penalty : "+ pVNS);
                System.out.println("VNS Delta  : " + delta(pInit, pVNS));
            }
               
            
//            tabus(timeslot, conflict_matrix, course, student, max_timeslot);
//            for(int i = 0; i < timeslot.length; i++){
//                System.out.println(Arrays.toString(tsHillClimb[i]));
//            }
            
            
        }
        catch(Exception e) {
            System.out.println("error: " + e);
            e.printStackTrace();
        }
    }
    public static double delta(double pInit, double pMethod) {
        double delta;
        
        delta = (pInit - pMethod)/pInit;
        
        return delta;
    }
    
    public static int[][] tabus(int[][]timeslot, int[][]conflict_matrix , ArrayList<String> course, ArrayList<String> student, int max_timeslot) {
            
            double in_penalty = 0;
            in_penalty = penalty(conflict_matrix,timeslot,student.size());
            
            Random r = new Random();

            int ran_exam1,ran_exam2,ran_exam3 = 0;
            int ran_slot1,ran_slot2,ran_slot3 = 0;
            
            int[][]sbest = timeslot.clone();
            int[][]bestcandidate = timeslot.clone();
            int[][]ts1 = timeslot.clone();
            int[][]ts2 = timeslot.clone();
            int[][]ts3 = timeslot.clone();
            int[][]ts4 = timeslot.clone();
            int[][]ts5 = timeslot.clone();
            
            LinkedList<int[][]> tabulist = new LinkedList<int[][]>();
            int maxtabusize = 10;
            tabulist.addLast(timeslot.clone());
            
            int ts_it = 1000;
            int iteration=0;
            
            double penalty1 = 0;
            double penalty2 = 0;
            double penalty3 = penalty(conflict_matrix, timeslot, student.size());
            
            boolean terminate = false;
            long starttime = System.nanoTime();
            while(iteration < ts_it ){
                iteration++;
                

                ArrayList<int[][]> sneighborhood = new ArrayList<>();

                boolean cek1 = false;
                boolean cek2 = false;
                boolean cek3 = false;
               
                do{
                    ran_exam1 = r.nextInt(course.size());
                    ran_slot1 = r.nextInt(max_timeslot);
                    cek1 = !check2(ran_exam1, ran_slot1, conflict_matrix, ts1);
                }while(cek1);
                ts1[ran_exam1][1] = ran_slot1; 
                sneighborhood.add(ts1);
                
                cek1 = false;

                
                do {                    
                    ran_exam1 = r.nextInt(course.size());
                    ran_slot1 = r.nextInt(max_timeslot);
                    ran_exam2 = r.nextInt(course.size());
                    ran_slot2 = r.nextInt(max_timeslot);
                    cek1 = !check2(ran_exam1, ran_slot1, conflict_matrix, ts2);
                    cek2 = !check2(ran_exam2, ran_slot2, conflict_matrix, ts2);
                } while(cek1 && cek2);
                ts2[ran_exam1][1] = ran_slot1;
                ts2[ran_exam2][1] = ran_slot2;
                sneighborhood.add(ts2);

                cek1 = false;
                cek2 = false;
                
                
                do {                    
                    ran_exam1 = r.nextInt(course.size());
                    ran_slot1 = r.nextInt(max_timeslot);
                    ran_exam2 = r.nextInt(course.size());
                    ran_slot2 = r.nextInt(max_timeslot);
                    ran_exam3 = r.nextInt(course.size());
                    ran_slot3 = r.nextInt(max_timeslot);
                    cek1 = !check2(ran_exam1, ran_slot1, conflict_matrix, ts3);
                    cek2 = !check2(ran_exam2, ran_slot2, conflict_matrix, ts3);
                    cek3 = !check2(ran_exam3, ran_slot3, conflict_matrix, ts3);
                } while(cek1 && cek2 && cek3);
                ts3[ran_exam1][1] = ran_slot1;
                ts3[ran_exam2][1] = ran_slot2;
                ts3[ran_exam3][1] = ran_slot3;
                sneighborhood.add(ts3);

                cek1 = false;
                cek2 = false;   
                cek3 = false;     

                do{
                    ran_exam1 = r.nextInt(course.size());
                    ran_exam2 = r.nextInt(course.size());
                    ran_slot1 = ts4[ran_exam1][1];
                    ran_slot2 = ts4[ran_exam2][1];
                    cek1 = !check2(ran_exam1, ran_slot1, conflict_matrix, ts4);
                    cek2 = !check2(ran_exam2, ran_slot2, conflict_matrix, ts4);
                }while(ran_exam1==ran_exam2 && cek2 && cek3);
                ts4[ran_exam1][1]=ran_slot2;
                ts4[ran_exam2][1]=ran_slot1;
                sneighborhood.add(ts4);
                
                cek1 = false;
                cek2 = false; 

                 do{
                    ran_exam1 = r.nextInt(course.size());
                    ran_exam2 = r.nextInt(course.size());
                    ran_exam3 = r.nextInt(course.size());
                    ran_slot1 = ts5[ran_exam1][1];
                    ran_slot2 = ts5[ran_exam2][1];
                    ran_slot3 = ts5[ran_exam3][1];
                    cek1 = !check2(ran_exam1, ran_slot1, conflict_matrix, ts5);
                    cek2 = !check2(ran_exam2, ran_slot2, conflict_matrix, ts5);
                    cek3 = !check2(ran_exam3, ran_slot3, conflict_matrix, ts5);
                }while(ran_exam1==ran_exam2 && ran_exam1==ran_exam3 && ran_exam2==ran_exam3 && cek1 && cek2 && cek3);
                ts5[ran_exam1][1]=ran_slot2;
                ts5[ran_exam2][1]=ran_slot3;
                ts5[ran_exam3][1]=ran_slot1;
                sneighborhood.add(ts5);
//                    System.out.println(sneighborhood.size());

                
                for(int i = 0; i < sneighborhood.size(); i++){
                    penalty1 = penalty(conflict_matrix, bestcandidate, student.size());
                    penalty2 = penalty(conflict_matrix, sneighborhood.get(i), student.size());
                    if(!(tabulist.contains(sneighborhood.get(i))) && penalty2<penalty1){
                        bestcandidate = sneighborhood.get(i);
                    }
                }
//                while (sneighborhood.size() > j) {
//                    penalty1 = penalty(conflict_matrix, bestcandidate, student.size());
//                    penalty2 = penalty(conflict_matrix, sneighborhood.get(j), student.size());
//                    if(!(tabulist.contains(sneighborhood.get(j))) && penalty2<penalty1){
//                        bestcandidate = sneighborhood.get(j);
//                    }
//                        j++;
//                }
                
                sneighborhood.clear();
                
                if(penalty1 < penalty3){
                    sbest = bestcandidate;
                    penalty3 = penalty1;
                }
                tabulist.addLast(bestcandidate);
                if(tabulist.size() > maxtabusize){
                    tabulist.removeFirst();
                }
                    //return sbest;
                    
                System.out.println("iteration "+iteration+" penalty "+ penalty3);

            }
            pTabu1 = penalty3;
            long endtime   = System.nanoTime();
            long time = endtime - starttime;
            
            
            penalty3 = penalty(conflict_matrix, sbest, student.size());
            schTS = sbest;
            //hillclimbing(conflict_matrix, timeslot, student.size(), course.size(), max_timeslot);
            tstime = time;
            System.out.println("time : " + (double)time/1000000000 + " s");
//            pTabu1 = penalty3;
//            System.out.println("initial penalty: "+ in_penalty);
//            System.out.println("tabu search penalty: "+ pTabu1);
//            
        return sbest;
    }
    
    public static double penalty(int[][]conflict_matrix,int[][]timeslot,int student){
        double penalty = 0;
        for(int i=0;i<conflict_matrix.length-1;i++){
                for(int j=i+1;j<conflict_matrix.length;j++){
                    if(conflict_matrix[i][j]!=0){
                        if(Math.abs(timeslot[j][1]-timeslot[i][1])>=1 && Math.abs(timeslot[j][1]-timeslot[i][1])<=5){
                            penalty = penalty + (conflict_matrix[i][j]*(Math.pow(2, (5-(Math.abs(timeslot[j][1]-timeslot[i][1]))))));
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
        long starttime = System.nanoTime();
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
            
//            System.out.println("iterasi "+(i+1)+" penalty "+ pHill1);
        }
        long endtime   = System.nanoTime();
        long time = endtime - starttime;
        hctime = time;
        
//        System.out.println("time : " + (double)time/1000000000 + " s");
        
        return timeslotH2;
        
    }
    
    public static void sima(int[][]timeslot, int[][]conflict_matrix , ArrayList<String> course, ArrayList<String> student, int max_timeslot) {
        double in_penalty = 0;
        in_penalty = penalty(conflict_matrix,timeslot,student.size());
        
        Random r = new Random();
        
        int ran_exam1,ran_exam2,ran_exam3 = 0;
        int ran_slot1,ran_slot2,ran_slot3 = 0;
        
        
        
    }
    public static int[][] vns(int[][]timeslot, int[][]conflict_matrix , ArrayList<String> course, ArrayList<String> student, int max_timeslot) {
        int ran_exam1,ran_exam2,ran_exam3,ran_examx = 0;
        int ran_slot1,ran_slot2,ran_slot3,ran_slotx = 0;
        
        int best_sol_vns[][] = timeslot.clone();
        int[][]sbest = timeslot.clone();
        int[][]bestcandidate = timeslot.clone();
        int[][]ts1 = timeslot.clone();
        int[][]ts2 = timeslot.clone();
        int[][]ts3 = timeslot.clone();
        int[][]ts4 = timeslot.clone();
        int[][]ts5 = timeslot.clone();
        
        int ts_it = 1000;
        int iteration=0;

        double penalty1 = 0;
        double penalty2 = 0;
        double bestpenalty = penalty(conflict_matrix, timeslot, student.size());

        Random r = new Random();

        boolean terminate = false;
        long starttime = System.nanoTime();
        
        iteration++;


        ArrayList<int[][]> sneighborhood = new ArrayList<>();

        boolean cek1 = false;
        boolean cek2 = false;
        boolean cek3,cekx = false;

        do{
            ran_exam1 = r.nextInt(course.size());
            ran_slot1 = r.nextInt(max_timeslot);
            cek1 = !check2(ran_exam1, ran_slot1, conflict_matrix, ts1);
        }while(cek1);
        ts1[ran_exam1][1] = ran_slot1; 
        sneighborhood.add(ts1);

        cek1 = false;


        do {                    
            ran_exam1 = r.nextInt(course.size());
            ran_slot1 = r.nextInt(max_timeslot);
            ran_exam2 = r.nextInt(course.size());
            ran_slot2 = r.nextInt(max_timeslot);
            cek1 = !check2(ran_exam1, ran_slot1, conflict_matrix, ts2);
            cek2 = !check2(ran_exam2, ran_slot2, conflict_matrix, ts2);
        } while(cek1 && cek2);
        ts2[ran_exam1][1] = ran_slot1;
        ts2[ran_exam2][1] = ran_slot2;
        sneighborhood.add(ts2);

        cek1 = false;
        cek2 = false;


        do {                    
            ran_exam1 = r.nextInt(course.size());
            ran_slot1 = r.nextInt(max_timeslot);
            ran_exam2 = r.nextInt(course.size());
            ran_slot2 = r.nextInt(max_timeslot);
            ran_exam3 = r.nextInt(course.size());
            ran_slot3 = r.nextInt(max_timeslot);
            cek1 = !check2(ran_exam1, ran_slot1, conflict_matrix, ts3);
            cek2 = !check2(ran_exam2, ran_slot2, conflict_matrix, ts3);
            cek3 = !check2(ran_exam3, ran_slot3, conflict_matrix, ts3);
        } while(cek1 && cek2 && cek3);
        ts3[ran_exam1][1] = ran_slot1;
        ts3[ran_exam2][1] = ran_slot2;
        ts3[ran_exam3][1] = ran_slot3;
        sneighborhood.add(ts3);

        cek1 = false;
        cek2 = false;   
        cek3 = false;     

        do{
            ran_exam1 = r.nextInt(course.size());
            ran_exam2 = r.nextInt(course.size());
            ran_slot1 = ts4[ran_exam1][1];
            ran_slot2 = ts4[ran_exam2][1];
            cek1 = !check2(ran_exam1, ran_slot1, conflict_matrix, ts4);
            cek2 = !check2(ran_exam2, ran_slot2, conflict_matrix, ts4);
        }while(ran_exam1==ran_exam2 && cek2 && cek3);
        ts4[ran_exam1][1]=ran_slot2;
        ts4[ran_exam2][1]=ran_slot1;
        sneighborhood.add(ts4);

        cek1 = false;
        cek2 = false; 

         do{
            ran_exam1 = r.nextInt(course.size());
            ran_exam2 = r.nextInt(course.size());
            ran_exam3 = r.nextInt(course.size());
            ran_slot1 = ts5[ran_exam1][1];
            ran_slot2 = ts5[ran_exam2][1];
            ran_slot3 = ts5[ran_exam3][1];
            cek1 = !check2(ran_exam1, ran_slot1, conflict_matrix, ts5);
            cek2 = !check2(ran_exam2, ran_slot2, conflict_matrix, ts5);
            cek3 = !check2(ran_exam3, ran_slot3, conflict_matrix, ts5);
        }while(ran_exam1==ran_exam2 && ran_exam1==ran_exam3 && ran_exam2==ran_exam3 && cek1 && cek2 && cek3);
        ts5[ran_exam1][1]=ran_slot2;
        ts5[ran_exam2][1]=ran_slot3;
        ts5[ran_exam3][1]=ran_slot1;
        sneighborhood.add(ts5);
        
        for(int i=0;i<ts_it;){
            int k=0;
            i=i+1;
            while(k<sneighborhood.size()){
                int [][]knx = sneighborhood.get(k);
                do{
                    ran_examx = r.nextInt(course.size());
                    ran_slotx = r.nextInt(max_timeslot);
                    cekx = !check2(ran_examx, ran_slotx, conflict_matrix, knx);
                }while(cekx);
                knx[ran_examx][1] = ran_slotx;
                cekx = false;
                int [][]knxx = hillClimb(conflict_matrix, knx, student.size(), course.size(), max_timeslot);
                penalty1 = penalty(conflict_matrix, knx, ts_it);
                penalty2 = penalty(conflict_matrix, knxx, ts_it);
                if(penalty2<bestpenalty){
                    bestpenalty = penalty2;
                    sbest = knxx;
                }
                else{
                    k=k+1;
                }
            }
           
            System.out.println("iterasi "+i+" penalty "+ bestpenalty);
        }       
        
        pVNS = bestpenalty;
        return best_sol_vns;
    }
}
    