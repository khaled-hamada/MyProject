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

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFS {
	
	private  List<State> startStates ;
	// number of queens 
	private int Queens;
        // chess board as indeses X and Y
	private Point[][] allPoints ;
        private  int solutionCount = 0;
        //Number of generated states 
        private int generatedStates = 0;
        //number of explored states 
        private int exploredStates = 0;
        //deafult constructor 
        public DFS(){
            this.Queens = 8;
            this.startStates =  new ArrayList<State>();
            this.allPoints = new Point[Queens][Queens];
        }
        
	public DFS(int queens){
            this.Queens = queens;
            this.startStates =  new ArrayList<State>();
            this.allPoints = new Point[Queens][Queens];
        }
	
        
        public int getGeneratedStatesNumber(){
            return this.generatedStates;
        }
        public int getExploredStatesNumber(){
            return this.exploredStates;
        }
        public int getQueensNumber(){
            return this.Queens;
        }
	
        private void makeBoard(){
            int rows = this.Queens;
            for(int i=0; i<rows; i++){
                for(int j=0; j<rows; j++){
                    this.allPoints[i][j] = new Point(i, j);
                                
		}
            }
            
        }
        
        private void generateInitialStates(){
            //add initial states to the states list 
            //chooes them randomly so we get a new solution each time we run the algorithm 

            // Fisrt : create a List of random numbers Between 0 and N
            int rows = this.Queens;
            List<Integer> l =new ArrayList<>();
            for(int i=0; i<rows; i++){

                while(true ){
                    int j = (int)(Math.random() * rows);
                   // System.out.println("j = \n"+j);
                   //  List<Point> l =state.getPointList();
                   if( !l.contains(j)){
                       l.add(j);
                      // System.out.print("i = "+i +", j= "+j+"\n");
                       break ;
                   }
                }
            }
         //  System.out.println("\n List numbers \n"+ l.toString());
           //SECOND Create initial states 
           for(Integer i:l){
               State state = new State();
               state.getPointList().add(new Point(0, i));
               state.setLineNum(0);
               this.startStates.add(state);

           }

    }
       
        public State getSolution(){
            //make chess board 
            makeBoard();
            //get initial random states 
            generateInitialStates();
            //run DFS 
            State solution = new State() ;
            boolean flag = false;
            for(State state : startStates){
                solution = runDFS(state);
                flag = true;
                //we need only on solution 
                if (flag)
                    break ;

            }
           // printSolution(solution);
            return solution ;
        }
	
	
	
    private  State runDFS(State state){
        // the frontier is a LIFO Queue i.e a Stack
        Stack<State> stack = new Stack<State>();
        stack.push(state);
        //a list of safe points 
        List<Point> l = new ArrayList<Point>();
        while(!stack.isEmpty()){

            State state2 = stack.pop();
            //increase number of explored states 
            this.exploredStates++;
            // if we find a solution 
            // then print it 
            // we find a solution when number of rows traversed equals number of queens 
            //note that we start indexing from ZERO so the condition is lineNum -1 

            if(state2.getLineNum() == this.Queens - 1){
              //  printSolution( state2);
                // if i remove this statement the algorithm will contiune solving the problem 
                //to find all possible soultions 
                // i.e if Number of queens =8 
                // the algorithm will find the 92 different solution and print them 
                // but in this case i need only the first solution the algorithm has found 
                return state2;				
            }

            //place queen in the next row 
            int currentLineNum = state2.getLineNum() + 1;
            //clear list of safe points to add new ones in the current row 
            l.clear();
            for(Point point : this.allPoints[currentLineNum]){
                //only choose safe states 
                if(isSafe(point, state2.getPointList())){
                        l.add(point);
                }
            }

            //shuffle point to get a random solution 
            for(int i =0; i<l.size() ;i++){
                int j= (int)(Math.random() * l.size());
                Point p1 =l.get(i);
                Point p2 = l.get(j);
                l.set(i, p2);
                l.set(j, p1);
            }

           //genrate new states depending on the safe points that we have found 
           for(Point p:l){
                State newState = new State();
                this.generatedStates++;
                for(Point point2 : state2.getPointList()){
                    newState.getPointList().add(new Point(point2.getX(), point2.getY()));
            }

            newState.getPointList().add(p);

            newState.setLineNum(currentLineNum);

            stack.push(newState);

           }

        }
        // No solution found 
        return null;
    }
	
	
	private boolean isSafe(Point point, List<Point> list){
            // As we know that we place queens row by row 
            //so there is only on queen in each row , so we do not need to check row for attacks 
            //we only need to check columns , diagonals (main and sub diagonals )
		for(Point point2 : list){
			if(point2.getY() == point.getY() 
			 || Math.abs(point2.getX() - point.getX()) == Math.abs(point2.getY() - point.getY()))
				return false;
		}
		return true;
	}
        
       
}