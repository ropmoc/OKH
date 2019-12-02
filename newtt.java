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
import java.util.Random;

/**
 *
 * @author DELL
 */
public class newtt {
    public static void main(String[] args) {
        String stu = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\sta-f-83.stu";
        String crs = "C:\\Users\\DELL\\Documents\\project\\OKH\\toronto\\sta-f-83.crs";
        timetabling(crs, stu);
        
    }
    public static void timetabling(String crs, String stu){
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
            
            System.out.println("jumlah course:");
            System.out.println(course);
            System.out.println("");
            
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
//            for(int i = 0; i < conflict_matrix.length; i++){
//                System.out.println(Arrays.toString(conflict_matrix[i]));
//            }
            
//            System.out.println("conflict student mengambil dua course");
//            for(int i = 0; i < conflict_matrix.length; i++) {
//                for(int j = 0; j < conflict_matrix.length; j++) {
//                    System.out.print(conflict_matrix[i][j] + " ");
//                }
//                System.out.println();
//            }
            
            
//            System.out.println("conflict binary");
//            int[][] binary = new int [course.size()][course.size()];
//		for(int i = 0; i < conflict_matrix.length; i++) {
//                    for(int j = 0; j < conflict_matrix.length; j++) {
//                        if(conflict_matrix[i][j] > 0)
//                                binary[i][j] = 1;
//                        System.out.print(binary[i][j]+" ");
//                    }
//                    System.out.println();
//		}
            
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
            
            for(int i = 0; i <degrees.length;i++){
                System.out.println(i + "" + Arrays.toString(degrees[i]));
            }
//            System.out.println("Degree course:");
//            
//            for(int i = 0; i < degrees.length;i++){
//                for(int j=0;j<2;j++){
//                    System.out.print(degrees[i][j]+" ");
//                }
//                System.out.println("");
//            }
            
           
            int ts=1;
            int [][] timeslot = new int[course.size()][2];
            
            int[][]sdegrees = new int[course.size()][2];    
            sdegrees=degrees;
           
            
            Arrays.sort(sdegrees, new Comparator<int[]>() { 
		@Override
		public int compare(int[] entry1, int[] entry2) { 
                    if (entry1[1] < entry2[1]) 
                        return 1; 
                    else
                        return -1; 
                  } 
                });
                // display array after sort
//                System.out.println("");
//                System.out.println("degree sorted in descending order");
//                for(int i = 0; i < sdegrees.length;i++){
//                    for(int j=0;j<2;j++){
//                        System.out.print(sdegrees[i][j]+" ");
//                    }
//                    System.out.println("");
//                }   


            //timesloting
            
            
            for(int i=0; i<sdegrees.length; i++){
                    for(int j=0; j<ts; j++){
                            if(issafe(i, j, conflict_matrix, sdegrees, timeslot)){
                                    timeslot[sdegrees[i][0]-1][1] = j;
                                    break;
                            }else{
                                    ts++;
                            }
                    }
            }
             
            

                
            
//            System.out.println("");
//            System.out.println("timetable");
//            for(int i = 0; i < timeslot.length;i++){
//                for(int j=0;j<timeslot[i].length;j++){
//                    timeslot[i][0] = i+1;
//                    System.out.print(timeslot[i][j]+" ");
//                }
//                System.out.println("");
//            }    
            
            
            
            //export
//            export(timeslot,filename);
            
            
            ///////////////////////////////////////////////////////////////////
            //penalty cij
            double penalty = 0;
            penalty = penalty(conflict_matrix,timeslot,student.size());
            System.out.println("penalty : " + penalty);
            
            //splitting timeslot 
            int[] index = new int[timeslot.length];
//            int[] slot = new int[timeslot.length];
            for (int i = 0; i < timeslot.length; i++) {
                for (int j = 0; j < timeslot[i].length; j++) {
                    index[i]=timeslot[i][0];
//                    slot[i]=timeslot[i][1];
                }
            }
            int max_timeslot = 0;
            
            for(int i = 0; i<timeslot.length; i++) {
			if(timeslot[i][1] > max_timeslot)
				max_timeslot = timeslot[i][1];
		}
            
            /////////////////
            //inisiasi random
            Random r = new Random();
            //int randomindexcourse=0;
            //int randomslot=0;
            int rindex1,rindex2,rindex3 = 0;
            int rslot1,rslot2,rslot3 = 0;
            
            
            //inisiasi initial solution
            int[][]sbest = timeslot.clone();
            int[][]bestcandidate = timeslot.clone();
            int[][]timeslot1 = timeslot.clone();
            
            //inisiasi tabulist
            LinkedList<int[][]> tabulist = new LinkedList<int[][]>();
            int maxtabusize = 10;
            tabulist.addLast(timeslot.clone());
            
            //inisiasi iterasi
            int maxiteration = 1000;
            int iteration=0;
            
            //inisasi itung penalty
            double penalty1 = 0;
            double penalty2 = 0;
            double penalty3 = 0;
            
            boolean terminate = false;
            long starttimer = System.nanoTime();
            while(!terminate){
                iteration++;
                
                    //##search candidate solution / search neighbor
                    //sneighborhood = getneighbor(bestcandidate)
                    ArrayList<int[][]> sneighborhood = new ArrayList<>();
                    
                        
                    //move 1
                    rindex1 = r.nextInt(course.size());
                    rslot1 = r.nextInt(max_timeslot);
                    if (issafe2(rindex1, rslot1, conflict_matrix, timeslot1)) {
                        timeslot1[rindex1][1] = rslot1;
                    }
                    sneighborhood.add(timeslot1);
                    
                    //move 2
                    rindex1 = r.nextInt(course.size());
                    rslot1 = r.nextInt(max_timeslot);
                    rindex2 = r.nextInt(course.size());
                    rslot2 = r.nextInt(max_timeslot);
                    if (issafe2(rindex1, rslot1, conflict_matrix, timeslot1)) {
                        timeslot1[rindex1][1] = rslot1;
                    }
                    if (issafe2(rindex2, rslot2, conflict_matrix, timeslot1)) {
                        timeslot1[rindex2][1] = rslot2;
                    }
                    sneighborhood.add(timeslot1);
                    
                    //move3
                    rindex1 = r.nextInt(course.size());
                    rslot1 = r.nextInt(max_timeslot);
                    rindex2 = r.nextInt(course.size());
                    rslot2 = r.nextInt(max_timeslot);
                    rindex3 = r.nextInt(course.size());
                    rslot3 = r.nextInt(max_timeslot);
                    if (issafe2(rindex1, rslot1, conflict_matrix, timeslot1)) {
                        timeslot1[rindex1][1] = rslot1;
                    }
                    if (issafe2(rindex2, rslot2, conflict_matrix, timeslot1)) {
                        timeslot1[rindex2][1] = rslot2;
                    }
                    if (issafe2(rindex3, rslot3, conflict_matrix, timeslot1)) {
                        timeslot1[rindex3][1] = rslot3;
                    }
                    sneighborhood.add(timeslot1);
                    
                    
                    
                    //swap 2
                    do{
                        rindex1 = r.nextInt(course.size());
                        rindex2 = r.nextInt(course.size());
                    }while(rindex1==rindex2);
                    rslot1 = timeslot1[rindex1][1];
                    rslot2 = timeslot1[rindex2][1];
                    if (issafe2(rindex1, rslot2, conflict_matrix, timeslot1)) {
                        timeslot1[rindex1][1]=rslot2;
                    }
                    if (issafe2(rindex2, rslot1, conflict_matrix, timeslot1)) {
                        timeslot1[rindex2][1]=rslot1;
                    }
                    sneighborhood.add(timeslot1);
                    
                     //swap 3
                     do{
                        rindex1 = r.nextInt(course.size());
                        rindex2 = r.nextInt(course.size());
                        rindex3 = r.nextInt(course.size());
                    }while(rindex1==rindex2||rindex1==rindex3||rindex2==rindex3);
                    rslot1 = timeslot1[rindex1][1];
                    rslot2 = timeslot1[rindex2][1];
                    rslot3 = timeslot1[rindex3][1];
                    if (issafe2(rindex1, rslot2, conflict_matrix, timeslot1)) {
                        timeslot1[rindex1][1]=rslot2;
                    }
                    if (issafe2(rindex2, rslot3, conflict_matrix, timeslot1)) {
                        timeslot1[rindex2][1]=rslot3;
                    }
                    if (issafe2(rindex3, rslot1, conflict_matrix, timeslot1)) {
                        timeslot1[rindex3][1]=rslot1;
                    }
                    sneighborhood.add(timeslot1);
                    
//                    do{
//                        rslot1=r.nextInt(timeslot.length);
//                        rslot2=r.nextInt(timeslot.length);
//                    }while(rslot1==rslot2);
//                    int temp[] = timeslot1[rslot1];
//                    timeslot1[rslot1] = timeslot1[rslot2];
//                    timeslot1[rslot2] = temp;
//
//                     //fix index
//                    for (int i = 0; i < timeslot1.length; i++) {
//                        for (int j = 0; j < timeslot1[i].length; j++) {
//                            timeslot1[i][0]=index[i];
//                        }
//                    }
//                    sneighborhood.add(timeslot1);
//                    int j = 0;
//                    while (sneighborhood.size() > j) {
//                        System.out.println(j);
//                        System.out.println(sneighborhood.get(j));
//                        j++;
//                    }
                    

            //print hasil swap
//            System.out.println("temp timeslot");
//            for (int i = 0; i < timeslot1.length; i++) {
//                for (int j = 0; j < timeslot1[i].length; j++) {
//                    System.out.print(timeslot1[i][j]+" ");
//                }
//                System.out.println("");
//            }
//            System.out.println("");

                   
                            
                   
                    
//                    Iterator<int[][]> iterator = sneighborhood.iterator();
//                    while (iterator.hasNext()) {
//                        penalty2 = penalty(conflict_matrix, iterator.next(), student.size());
//                        penalty1 = penalty(conflict_matrix, bestcandidate, student.size());
//                        if(!(tabulist.contains(iterator.next())) && penalty2>penalty1){
//                            bestcandidate = iterator.next();
//                        }
//                    }
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

                if (iteration == maxiteration) {
                    terminate = true;
                }
            }
            long endtimer   = System.nanoTime();
            long totaltimer = endtimer - starttimer;
            
            
            penalty3 = penalty(conflict_matrix, sbest, student.size());
            
            //hillclimbing(conflict_matrix, timeslot, student.size(), course.size(), max_timeslot);
            
            System.out.println("time : " + (double)totaltimer/1000000000 + " detik");
            
            System.out.println("initial penalty: "+penalty);
            System.out.println("tabu search penalty: "+ penalty3);
            
            double delta = 0;
            delta = ((penalty-penalty2)/penalty2)*100;
            //System.out.println("improvement : " +delta+ "%");
         
            
        } catch(Exception e) {
            System.out.println("error: " + e);
            e.printStackTrace();
        }
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
    public static boolean issafe2(int indexcourse, int ntimeslot, int conf[][], int[][]timeslot){
	for(int i=0; i<conf.length;i++)
		if(conf[indexcourse][i]!=0 && timeslot[i][1] == ntimeslot)
                    return false;
        return true;
    }
    
    public static boolean issafe(int index, int ntimeslot, int conf[][], int[][]sdegrees, int[][]timeslot){
	for(int i=0; i<sdegrees.length;i++)
		if(conf[sdegrees[index][0]-1][i]!=0 && timeslot[i][1] == ntimeslot)
                    return false;
        return true;
    }
    
    public static void hillclimbing (int conf[][], int[][]timeslot, int stu, int cour, int max){
	Random r = new Random();
        int randomindexcourse=0;
        int randomslot=0;
        int timeslot1[][]=timeslot.clone();
        int timeslot2[][]=timeslot.clone();
        double penalty1 = penalty(conf, timeslot2, stu);
        double penalty2 = 0;
        for (int i = 0; i < 1000000; i++) {
            randomindexcourse=r.nextInt(cour);
            randomslot=r.nextInt(max);

            if (issafe2(randomindexcourse, randomslot, conf, timeslot2)) {
                timeslot1[randomindexcourse][1] = randomslot;
                penalty2 = penalty(conf, timeslot1, stu);
                if(penalty1 > penalty2){
                    penalty1 = penalty(conf, timeslot1, stu);
                    timeslot2[randomindexcourse][1] = timeslot1[randomindexcourse][1];
                }else{
                    timeslot1[randomindexcourse][1] = timeslot2[randomindexcourse][1];
                }
            }
//            System.out.println("iterasi "+(i+1)+" penalty "+ penalty(conf, timeslot1, stu));
        }
    }
    
    public static void export(int[][]timeslot, String filename){
        try{    
            FileWriter fw=new FileWriter("C:\\TORONTO\\"+filename+".sol");    
            for (int i = 0; i <timeslot.length; i++) {
                for (int j = 0; j <timeslot[i].length; j++) {
                    timeslot[i][0]=i;
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
