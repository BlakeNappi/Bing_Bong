/**
 * @author Blake C. Nappi
 */

import java.awt.Color;
import java.awt.Graphics;


public class Collection implements DataCollection {

	private final int SIZE = 15;
	private int numBalls;
	private Ball[] myBalls = new Ball[SIZE];

	public Collection(){



	}//Collection

	//adds a ball to the myBalls array
	public void add(Ball someItem) {
		if(myBalls != null){
			if(numBalls == myBalls.length){
				Ball[] temp = new Ball[myBalls.length * 2];
				for(int i =0; i < myBalls.length; i++)
					temp[i] = myBalls[i];
				myBalls = temp;
			}
		}
		
		myBalls[numBalls] = someItem;
		numBalls++;

	}//add

	//removes a random ball
	public void remove() {
		if(numBalls != 0){
			boolean searching = true;
			while (searching){					//stops nullpointer exception for balls already
				int num = (int) (Math.random() * numBalls);	//removed
				if(myBalls[num] != null){
					searching = false;
					myBalls[num] = null;
				}
			}
		}
		
	}//remove

	

	//paints balls in myBalls[]
	public void paint(Graphics pane) {

		if(myBalls != null){
			for(int i = 0; i < numBalls; i++)
				if(myBalls[i] != null)
					myBalls[i].paint(pane);
		}
	}//paint

	//gets rid of all the balls
	public void reset() {
		Ball [] temp = new Ball[SIZE];
		myBalls = temp;
		numBalls = 0;

	}//reset

	
	//updates balls' position
	public void update(){
		
		for(int i = 0; i < numBalls; i++)
			if(myBalls[i] != null)
				myBalls[i].update();
		
	}//update



}