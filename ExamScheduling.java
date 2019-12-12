/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
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
    static long vnstime;
    static int [][] sch1;
    static int [][] schHC;
    static int [][] schTS;
    static int [][] schVNS;
    static int nslot;
    static int method;
    static ArrayList<Double> listPen = new ArrayList<Double>();
    static ArrayList<Double> listPenVns = new ArrayList<Double>();
    static ArrayList<Double> listPenTS = new ArrayList<Double>();
    
    public static void main(String[] args) {
        String cars91_crs = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\car-s-91.crs";
        String cars91_stu = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\car-s-91.stu";
        
        String carf92_crs = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\car-f-92.crs";
        String carf92_stu = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\car-f-92.stu";

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
        System.out.println("3. VNS");
        System.out.println("4. VNS v Tabu Search");
        System.out.println("choose method : ");
        method = in.nextInt();

        
        switch(input) {
            case 1 :
                timeTabling(cars91_crs, cars91_stu,35);
                
                break;
            case 2 :
                timeTabling(carf92_crs, carf92_stu,32);
                
                break;
            case 3 :
                timeTabling(earf83_crs, earf83_stu, 24);
                break;
            case 4 :
                timeTabling(hecs92_crs, hecs92_stu,18);
                
                break;
            case 5 :
                timeTabling(kfus93_crs, kfus93_stu,20);
                
                break;
            case 6 :
                timeTabling(lsef91_crs, lsef91_stu,18);
                
                break;
            case 7 :
                timeTabling(purs93_crs, purs93_stu,42);
                
                break;
            case 8 :
                timeTabling(ryes93_crs, ryes93_stu,23);
                
                break;
            case 9 :
                timeTabling(staf83_crs, staf83_stu,13);
                    
                break;
            case 10 :
                timeTabling(tres92_crs, tres92_stu,23);
                
                break;
            case 11 :
                timeTabling(utas92_crs, utas92_stu,35);
                
                break;
            case 12 :
                timeTabling(utes92_crs, utes92_stu,10);
                ;            
                break;
            case 13 :
                timeTabling(yorf83_crs, yorf83_stu,21);
                          
                break;
            case 0 :
                System.out.println("exit");
                break;
            default :
                break;
            }

            in.close();
        

    }
    public static void timeTabling(String crs, String stu, int maxts) {
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
            int ts=1;
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
            
            int [][] timeslot = new int[course.size()][2];
            int [][] sat = new int[course.size()][2];
            for(int  i=0; i<timeslot.length; i++) {
                timeslot[i][0] = i+1;
                timeslot[i][1] = -1;
                sat[i][0] = sort_degrees[i][0];
                sat[i][1] = course.size();
            }
            System.out.println(maxts);
            /*for(int i=0; i<timeslot.length; i++)
            {
                for(int j=0; j<timeslot[i].length; j++)
                {
                    System.out.print(sat[i][j] + " ");
                }
                System.out.println();
            }*/


            for(int i=0; i<course.size(); i++){
                int index = calculate(sat, 10000);
                //System.out.println(index);
                for (int j=0; j<=ts; j++){
                    if(check2(sat[index][0]-1, j, conflict_matrix, timeslot)){
                        timeslot[sat[index][0]-1][1] = j;
                        sat[index][1] = 100000;
                        int ind =0;
                        for(int k=0; k<conflict_matrix.length; k++)
                        {
                            if(conflict_matrix[sat[index][0]-1][k]!=0)
                            {
                                ind = k;
                                for(int l=0; l<sat.length; l++)
                                {
                                    if(sat[l][0]==k+1)
                                    {
                                        sat[l][1] = sat[l][1]-1;
                                    }
                                }
                            }
                        }
                        break;
                    }
                    else{
                        ts++;
                    }
                }
            }

           
            for(int i = 0; i < timeslot.length; i++){
                System.out.println(Arrays.toString(timeslot[i]));
            }
            
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
                int tsHillClimb[][]=hillClimb(conflict_matrix, timeslot, student.size(), course.size(), maxts);
                System.out.println("done");
                System.out.println("number of timeslot : "+nslot);
                System.out.println("correct timeslot : "+maxts);
                System.out.println("Initial Penalty : "+pInit);
                System.out.println("HC penalty : "+ pHill1);
                System.out.println("HC Delta  : " + delta(pInit, pHill1));
                System.out.println("HC time : " + hctime);
                export(schHC, "test");
            
            } else if(method == 2){
                int tsTabus[][]= tabus(timeslot, conflict_matrix, course, student, maxts);
                System.out.println("done");
                System.out.println("number of timeslot : "+nslot);
                System.out.println("correct timeslot : "+maxts);
                System.out.println("Initial Penalty : "+pInit);
                System.out.println("TS Penalty : "+ pTabu1);
                System.out.println("TS Delta  : " + delta(pInit, pTabu1));
                System.out.println("TS time : " + tstime);
//                for(int i = 0;i<listPen.size();i++){
//                    System.out.println(listPen.get(i));
//                    
//                }
                for(int i =0;i<tsTabus.length;i++){
                    System.out.println(Arrays.toString(tsTabus[i]));
                }
                
            }else if(method == 3) {
                int tsvns[][]=vns(timeslot, conflict_matrix, course, student, maxts);
                System.out.println("done");
                System.out.println("number of timeslot : "+nslot);
                System.out.println("correct timeslot : "+maxts);
                System.out.println("Initial Penalty : "+pInit);
                System.out.println("VNS Penalty : "+ pVNS);
                System.out.println("VNS Delta  : " + delta(pInit, pVNS));
            } 
            else if(method == 4) {
//                int tsHillClimb[][]=hillClimb(conflict_matrix, timeslot, student.size(), course.size(), max_timeslot);
                int tsvns[][]=vns(timeslot, conflict_matrix, course, student, max_timeslot);
                int tsTabus[][]= tabus(timeslot, conflict_matrix, course, student, max_timeslot);
                System.out.println("done");
                System.out.println("number of timeslot : "+nslot);
                System.out.println("correct timeslot : "+maxts);
                System.out.println("Initial Penalty : "+pInit);
                System.out.println("VNS penalty : "+ pVNS);
                System.out.println("VNS Delta  : " + delta(pInit, pVNS));
                System.out.println("VNS time : " + vnstime);
                System.out.println("TS Penalty : "+ pTabu1);
                System.out.println("TS Delta  : " + delta(pInit, pTabu1));
                System.out.println("TS time : " + tstime);
                System.out.println("===============================");
                System.out.println("List penalty VNS");
                for(int i=0; i<listPenVns.size();i++){
                    System.out.println(listPenVns.get(i));
                }
                System.out.println("===============================");
                System.out.println("List penalty TS");
                for(int i=0; i<listPen.size();i++){
                    System.out.println(listPen.get(i));
                }
                System.out.println("===============================");
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
        
        delta = ((pInit - pMethod)/pInit)*100;
        
        return delta;
    }
    public static int calculate(int[][]sat, int batas)
    {
        int min = batas;
        int index = 0;
        for(int i=0; i<sat.length; i++) {
            if (sat[i][1] < min) {
                min = sat[i][1];
                index = i;
            }
        }
        return index;
    }
    public static int[][] tabus(int[][]timeslot, int[][]conflict_matrix , ArrayList<String> course, ArrayList<String> student, int maxts) {
            
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
            int[][]temp = timeslot.clone();
            
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
                    ran_slot1 = r.nextInt(maxts);
                    cek1 = !check2(ran_exam1, ran_slot1, conflict_matrix, ts1);
                }while(cek1);
                ts1[ran_exam1][1] = ran_slot1; 
                sneighborhood.add(ts1);
                
                cek1 = false;
                
                temp = ts2;
                do {                    
                    ran_exam1 = r.nextInt(course.size());
                    ran_slot1 = r.nextInt(maxts);
                    cek1 = !check2(ran_exam1, ran_slot1, conflict_matrix, temp);
                } while(cek1);
                temp[ran_exam1][1] = ran_slot1;
                do {
                    ran_exam2 = r.nextInt(course.size());
                    ran_slot2 = r.nextInt(maxts);
                    cek2 = !check2(ran_exam2, ran_slot2, conflict_matrix, temp);
                } while (cek2);
                temp[ran_exam2][1] = ran_slot2;
                ts2 = temp;
                sneighborhood.add(ts2);
                
                cek1 = false;
                cek2 = false;
                
                temp = ts3;
                do {                    
                    ran_exam1 = r.nextInt(course.size());
                    ran_slot1 = r.nextInt(maxts);
                    cek1 = !check2(ran_exam1, ran_slot1, conflict_matrix, temp);
                } while(cek1);
                temp[ran_exam1][1] = ran_slot1;
                do {
                    ran_exam2 = r.nextInt(course.size());
                    ran_slot2 = r.nextInt(maxts);
                    cek2 = !check2(ran_exam2, ran_slot2, conflict_matrix, temp);
                } while (cek2);
                temp[ran_exam2][1] = ran_slot2;
                do {
                    ran_exam3 = r.nextInt(course.size());
                    ran_slot3 = r.nextInt(maxts);
                    cek3 = !check2(ran_exam3, ran_slot3, conflict_matrix, temp);
                } while (cek3);
                temp[ran_exam3][1] = ran_slot3;
                ts3 = temp;                
                sneighborhood.add(ts3);
//
                cek1 = false;
                cek2 = false;   
                cek3 = false;     
//              
                
                
//                do{
//                    temp = ts4;
//                    do{
//                        ran_exam1 = r.nextInt(course.size());
//                        ran_exam2 = r.nextInt(course.size());
//                        ran_slot1 = temp[ran_exam1][1];
//                        ran_slot2 = temp[ran_exam2][1];
//                    }while(ran_exam1==ran_exam2 && ran_slot1==ran_slot2);
//                    cek1 = !check2(ran_exam1, ran_slot2, conflict_matrix, temp);
//                    cek2 = !check2(ran_exam2, ran_slot1, conflict_matrix, temp);
//                }while(cek1 && cek2);
//                temp[ran_exam1][1]=ran_slot2;
//                temp[ran_exam2][1]=ran_slot1;
//                ts4 = temp;
//                sneighborhood.add(ts4);
//                
//                cek1 = false;
//                cek2 = false; 
//                
//                do{
//                    temp = ts5;
//                    do{
//                        ran_exam1 = r.nextInt(course.size());
//                        ran_exam2 = r.nextInt(course.size());
//                        ran_exam3 = r.nextInt(course.size());
//                        ran_slot1 = temp[ran_exam1][1];
//                        ran_slot2 = temp[ran_exam2][1];
//                        ran_slot3 = temp[ran_exam3][1];
//                    }while(ran_exam1==ran_exam2 && ran_slot1==ran_slot2 && ran_exam1==ran_exam3 && ran_slot1==ran_slot3 &&ran_exam3==ran_exam2 && ran_slot3==ran_slot2);
//                    cek1 = !check2(ran_exam1, ran_slot2, conflict_matrix, temp);
//                    if(cek1 = true){
//                        break;
//                    }
//                    temp[ran_exam1][1]=ran_slot2;
//                    cek2 = !check2(ran_exam2, ran_slot3, conflict_matrix, temp);
//                    if(cek2 = true){
//                        break;
//                    }
//                    temp[ran_exam2][1]=ran_slot3;
//                    cek2 = !check2(ran_exam3, ran_slot1, conflict_matrix, temp);
//                    if(cek2 = true){
//                        break;
//                    }
//                    temp[ran_exam3][1]=ran_slot1;
//                }while(cek1 && cek2 && cek3);
//                ts5 = temp;
//                sneighborhood.add(ts5);
//                 do{
//                    ran_exam1 = r.nextInt(course.size());
//                    ran_exam2 = r.nextInt(course.size());
//                    ran_exam3 = r.nextInt(course.size());
//                    ran_slot1 = ts5[ran_exam1][1];
//                    ran_slot2 = ts5[ran_exam2][1];
//                    ran_slot3 = ts5[ran_exam3][1];
//                    cek1 = !check2(ran_exam1, ran_slot1, conflict_matrix, ts5);
//                    cek2 = !check2(ran_exam2, ran_slot2, conflict_matrix, ts5);
//                    cek3 = !check2(ran_exam3, ran_slot3, conflict_matrix, ts5);
//                }while(ran_exam1==ran_exam2 && ran_exam1==ran_exam3 && ran_exam2==ran_exam3 && cek1 && cek2 && cek3);
//                ts5[ran_exam1][1]=ran_slot2;
//                ts5[ran_exam2][1]=ran_slot3;
//                ts5[ran_exam3][1]=ran_slot1;
//                sneighborhood.add(ts5);
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
                    
                System.out.println(iteration+"-->"+" penalty "+ penalty3);
                if(iteration%10==0){
                    listPen.add(penalty3);
                }

            }
            pTabu1 = penalty3;
            long endtime   = System.nanoTime();
            long time = endtime - starttime;
            time = (long)time/1000000000;
            
            export(sbest, "test");
            
            penalty3 = penalty(conflict_matrix, sbest, student.size());
            schTS = sbest;
            //hillclimbing(conflict_matrix, timeslot, student.size(), course.size(), max_timeslot);
            tstime = time;
            
            
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
    
    public static int[][] hillClimb(int conf[][], int[][]timeslot, int stu, int cour, int maxts) {
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
            ran_slot=r.nextInt(maxts);

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
        time = (long)time/1000000000;
        hctime = time;
        schHC = timeslotH2;
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
    public static int[][] vns(int[][]timeslot, int[][]conflict_matrix , ArrayList<String> course, ArrayList<String> student, int maxts) {
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
        int[][]temp = timeslot.clone();
        
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
        
        long startvns = System.nanoTime();
            do{
                ran_exam1 = r.nextInt(course.size());
                ran_slot1 = r.nextInt(maxts);
                cek1 = !check2(ran_exam1, ran_slot1, conflict_matrix, ts1);
            }while(cek1);
            ts1[ran_exam1][1] = ran_slot1; 
            sneighborhood.add(ts1);

            cek1 = false;

            temp = ts2;
            do {                    
                ran_exam1 = r.nextInt(course.size());
                ran_slot1 = r.nextInt(maxts);
                cek1 = !check2(ran_exam1, ran_slot1, conflict_matrix, temp);
            } while(cek1);
            temp[ran_exam1][1] = ran_slot1;
            do {
                ran_exam2 = r.nextInt(course.size());
                ran_slot2 = r.nextInt(maxts);
                cek2 = !check2(ran_exam2, ran_slot2, conflict_matrix, temp);
            } while (cek2);
            temp[ran_exam2][1] = ran_slot2;
            ts2 = temp;
            sneighborhood.add(ts2);

            cek1 = false;
            cek2 = false;

            temp = ts3;
            do {                    
                ran_exam1 = r.nextInt(course.size());
                ran_slot1 = r.nextInt(maxts);
                cek1 = !check2(ran_exam1, ran_slot1, conflict_matrix, temp);
            } while(cek1);
            temp[ran_exam1][1] = ran_slot1;
            do {
                ran_exam2 = r.nextInt(course.size());
                ran_slot2 = r.nextInt(maxts);
                cek2 = !check2(ran_exam2, ran_slot2, conflict_matrix, temp);
            } while (cek2);
            temp[ran_exam2][1] = ran_slot2;
            do {
                ran_exam3 = r.nextInt(course.size());
                ran_slot3 = r.nextInt(maxts);
                cek3 = !check2(ran_exam3, ran_slot3, conflict_matrix, temp);
            } while (cek3);
            temp[ran_exam3][1] = ran_slot3;
            ts3 = temp;                
            sneighborhood.add(ts3);
//
            cek1 = false;
            cek2 = false;   
            cek3 = false;     
//              


            do{
                temp = ts4;
                do{
                    ran_exam1 = r.nextInt(course.size());
                    ran_exam2 = r.nextInt(course.size());
                    ran_slot1 = temp[ran_exam1][1];
                    ran_slot2 = temp[ran_exam2][1];
                }while(ran_exam1==ran_exam2 && ran_slot1==ran_slot2);
                cek1 = !check2(ran_exam1, ran_slot2, conflict_matrix, temp);
                if(cek1 = true){
                    break;
                }
                temp[ran_exam1][1]=ran_slot2;
                cek2 = !check2(ran_exam2, ran_slot1, conflict_matrix, temp);
                if(cek2 = true){
                    break;
                }
                temp[ran_exam2][1]=ran_slot1;
            }while(cek1 && cek2);
            ts4 = temp;
            sneighborhood.add(ts4);

            cek1 = false;
            cek2 = false; 

            do{
                temp = ts5;
                do{
                    ran_exam1 = r.nextInt(course.size());
                    ran_exam2 = r.nextInt(course.size());
                    ran_exam3 = r.nextInt(course.size());
                    ran_slot1 = temp[ran_exam1][1];
                    ran_slot2 = temp[ran_exam2][1];
                    ran_slot3 = temp[ran_exam3][1];
                }while(ran_exam1==ran_exam2 && ran_slot1==ran_slot2 && ran_exam1==ran_exam3 && ran_slot1==ran_slot3 &&ran_exam3==ran_exam2 && ran_slot3==ran_slot2);
                cek1 = !check2(ran_exam1, ran_slot2, conflict_matrix, temp);
                if(cek1 = true){
                    break;
                }
                temp[ran_exam1][1]=ran_slot2;
                cek2 = !check2(ran_exam2, ran_slot3, conflict_matrix, temp);
                if(cek2 = true){
                    break;
                }
                temp[ran_exam2][1]=ran_slot3;
                cek2 = !check2(ran_exam3, ran_slot1, conflict_matrix, temp);
                if(cek2 = true){
                    break;
                }
                temp[ran_exam3][1]=ran_slot1;
            }while(cek1 && cek2 && cek3);
            ts5 = temp;
            sneighborhood.add(ts5);
        
        for(int i=0;i<ts_it;){
            int k=0;
           
            while(k<sneighborhood.size()){
                //shaking
                int [][]knx = sneighborhood.get(k);
                do{
                    ran_examx = r.nextInt(course.size());
                    ran_slotx = r.nextInt(maxts);
                    cekx = !check2(ran_examx, ran_slotx, conflict_matrix, knx);
                }while(cekx);
                knx[ran_examx][1] = ran_slotx;
                cekx = false;
                //local search
                int [][]knxx = hillClimb(conflict_matrix, knx, student.size(), course.size(), maxts);
                penalty1 = penalty(conflict_matrix, knx, student.size());
                penalty2 = penalty(conflict_matrix, knxx, student.size());
                if(penalty2<bestpenalty){
                    bestpenalty = penalty2;
                    sbest = knxx;
                }
                else{
                    k=k+1;
                }
            }
            i=i+1;
            System.out.println(i+"-->"+" penalty "+ bestpenalty);
            if(i%10==0){
                listPenVns.add(bestpenalty);
            }
        }       
        long endvns   = System.nanoTime();
        long time = endvns - startvns;
        time = (long)time/1000000000;
        schVNS = sbest;
        
        pVNS = bestpenalty;
        vnstime = time;
        return best_sol_vns;
    }
    public static void export(int[][]timeslot, String filename){
        try{    
            FileWriter fw=new FileWriter("C:\\Users\\DELL\\Documents\\project\\OKH\\test\\"+filename+".sol");    
            for (int i = 0; i <timeslot.length; i++) {
                for (int j = 0; j <timeslot[i].length; j++) {
                    timeslot[i][0]=i+1;
                      fw.write(timeslot[i][j]+ " ");
                }
                fw.write("\n");  
            }
             
            fw.close();    
        } catch(Exception e){
        	System.out.println(e);
        }    
            System.out.println("File "+filename+".sol berhasil disimpan di C");    
    }
}
    