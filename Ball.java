/**
 * @author Blake C. Nappi
 * Programming Project #2 (Bing Bong)
 * CSC 212 Spring 2015
 * Due: 02/19/15
 */

//These are the imported libraries needed so I could access their methods!
import java.awt.Color;
import java.awt.Graphics;


public class Ball {
	
	private int x, y;			//coordinates 
	
	private final int RADIUS;	//radius of balls
	
	private final double GRAVITY,	//constant pull on the ball downwards
							BOUNCE;	 //how much the ball goes up after hitting
											//bottom of box
	
	private float sX, sY;		//shift in X and Y
	
	private Color myColor; 			// instantiate color variable of type color
	

	//constructor
	public Ball(){
		
		x =  (int)(Math.random() * 400) + 50;		//randomly generates X and Y
		y =  (int)(Math.random() * 250) + 50;
		
		RADIUS = 30;
		BOUNCE = (Math.random() * 0.9);			//randomly generates BOUNCE and GRAVITY
		GRAVITY = (Math.random() + 0.25);
		
		double temp = (Math.random() * 2);
		
		if(temp > 1.25)
			sX = 1.75f;	//ball falls going left or right
		else
			sX = -1.75f;
		
		sY = 1.75f;
		
		rnColor();
		
	}//Ball

	
	//sets the ball to a random color
	private void rnColor(){
		myColor = new Color( (int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
	}//rnColor


	
	//pants the ball
	public void paint(Graphics pane){
		pane.setColor(myColor);			//color of ball
		pane.fillOval(x, y, RADIUS, RADIUS);
		
		pane.setColor(Color.black);		//outline
		pane.drawOval(x, y, RADIUS, RADIUS);
		
	}//paint

	
	//updates the x and y position of the ball
	public void update(){
		
		if(x <= 55 || x >= 550 - RADIUS)	//left and right sides of box
			sX = -sX;
		
		if(y >= 600 - RADIUS){	//bottom of box
			sY = -sY;
			sY *= BOUNCE;		//make ball slow down because of bounce
		}else
			sY += GRAVITY;		//gravity pulls down
		
		x += sX;		//adds shift in X and Y to X and Y
		y += sY;
		
	}//update
	
}//end Ball
