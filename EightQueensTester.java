/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eightqueens;

/**
 *
 * @author Kahled Osman
 */
public class EightQueensTester {
   // public static int sol[][] ;
    public static void main(String[] args) {
        //indicating whether to run the safe algorithm of the blind one 
        boolean runSafeAlgorithm = false;
        long startTime = System.currentTimeMillis();
        
        DFS d = new DFS(10 , runSafeAlgorithm);
        State s = d.getSolution();
        int gStates = d.getGeneratedStatesNumber();
        int exStates = d.getExploredStatesNumber();
        int nQueens = d.getQueensNumber();
        printSolution(s, nQueens);
       // sol =  new int[nQueens][nQueens];
        
        System.out.println("Number of Queens is \n "+nQueens);
        //System.out.println("number of solutions \n" + solutionCount);
        System.out.println("number of generated states  = \n"+ gStates);
        System.out.println("number of explored  states  = \n"+ exStates);
        long FinishTime = System.currentTimeMillis();
        System.out.println("finishing time is : \n"+ (FinishTime - startTime)+ " MS");
       // System.out.println("Solution \n"+sol.toString());
       
       
       
	}
     //i will edit this method to return  1-D array contains the queens columns numbers only 
    // like this [ 2,4,7,6,8,......] 
        public static void  printSolution(State state , int nQueens){
            if(state != null)
                for(Point goalpoint : state.getPointList()){
                    for(int i=0; i<nQueens; i++){
                            if(i != goalpoint.getY()){
                                    System.out.print("_ ");
                                  //  sol[i][goalpoint.getY()] = 0;
                            }
                            else{
                                    System.out.print("Q ");
                                 //   sol[i][goalpoint.getY()] = 1;
                            }
                    }
                    System.out.println(); 
               
        }
        else
                System.out.println("NO solution has been found ");
        System.out.println();
            
        }
        
       
}
