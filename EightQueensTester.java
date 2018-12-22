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
    
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        
        DFS d = new DFS(60);
        State s = d.getSolution();
        int gStates = d.getGeneratedStatesNumber();
        int exStates = d.getExploredStatesNumber();
        int nQueens = d.getQueensNumber();
        printSolution(s, nQueens);
        
      
        System.out.println("Number of Queens is \n "+nQueens);
        //System.out.println("number of solutions \n" + solutionCount);
        System.out.println("number of generated states  = \n"+ gStates);
        System.out.println("number of explored  states  = \n"+ exStates);
        long FinishTime = System.currentTimeMillis();
        System.out.println("finishing time is : \n"+ (FinishTime - startTime)+ " MS");

	}
     //i will edit this method to return  1-D array contains the queens columns numbers only 
    // like this [ 2,4,7,6,8,......] 
        public static void  printSolution(State state , int nQueens){
            for(Point goalpoint : state.getPointList()){
                for(int i=0; i<nQueens; i++){
                        if(i != goalpoint.getY())
                                System.out.print("_ ");
                        else
                                System.out.print("Q ");
                }
                System.out.println(); 
               
        }
        System.out.println();
            
        }

}
