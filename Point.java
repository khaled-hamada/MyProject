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
public class Point{
	private int X;
	private int Y;
	
	public Point(int x, int y){
		this.X = x;
		this.Y = y;
	}
	
	public int getX(){
		return this.X;
	}
	
	public int getY(){
		return this.Y;
	}
	
	public void setX(int x){
		this.X = x;
	}
	
	public void setY(int y){
		this.Y = y;
	}

}