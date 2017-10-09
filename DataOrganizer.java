/**
 * @author Blake C. Nappii
 * Programming Project #2 Bing Bong
 * CSC 212 Spring 2015
 * Due: 02/19/2015
 */

//These are the imported libraries needed so I could access their methods!
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.*;							//	AWT = "Abstract Window Toolkit"
import java.awt.event.*;					//		or "Another Window Toolkit"
import java.util.Random;



public class DataOrganizer extends Frame implements  MouseListener, AlarmListener {


	private Collection myCollection;
	private Abutton slowerButton, fasterButton, throwButton,
	resetButton, removeButton;				//our buttons

	private boolean running = false;		//to run alarm or not

	private UneFenetre myWindow = new UneFenetre();	//	A handle on the window

	private int lastX, lastY,				//	To keep the mouse location
	speed = 100;			//	speed of program

	private Alarm alarm;

	public DataOrganizer(){
		//Set the title
		setTitle("Bing Bong");	//	We set the characteristics of our
		setLocation(250, 150);				//		drawing window
		setSize(650, 700);
		setBackground(Color.lightGray);
		setVisible(true);					//	And we make it appear

		addWindowListener(myWindow);		//	To check on the window
		addMouseListener(this);				//		and on the mouse


		int buttonX = 30;	//button X and Y
		int buttonY = 50;

		//Make the Random button and assign its attributes
		slowerButton = new Abutton("Slower", Color.red, buttonX + 30, buttonY);
		//set dimensions
		buttonX += 1.5*Abutton.BUTTON_WIDTH;
		//Make the Max button and assign its attributes
		fasterButton = new Abutton("Faster", Color.blue, buttonX, buttonY);
		//set dimensions
		buttonY += 1.1*Abutton.BUTTON_HEIGHT;
		//Make the Min button and assign its attributes
		throwButton = new Abutton("Throw", Color.orange, buttonX + 75 , buttonY - 35);
		//set dimensions
		buttonY += 1.1*Abutton.BUTTON_HEIGHT;
		//Make the Remove button and assign its attributes
		resetButton = new Abutton("Reset", Color.gray, buttonX + 150 , buttonY - 70);

		buttonY += 1.1*Abutton.BUTTON_HEIGHT;	//set dimensions
		buttonX -= 1.5*Abutton.BUTTON_WIDTH;	//Make the quit button and assign its attributes

		myCollection = null;
		removeButton = new Abutton("Remove", Color.green, buttonX +330 , buttonY - 105 );
		//set dimensions
		buttonX += 3.5*Abutton.BUTTON_WIDTH;
		//set dimensions
		buttonY += 1*Abutton.BUTTON_HEIGHT;

		alarm = new Alarm("beep", this);
		alarm.setPeriod(speed);
		alarm.start();

		myCollection = new Collection();

	}//DataOrganizer


	private void check(){

		//check to see if random button is being clicked
		if (slowerButton.isInside(lastX, lastY)) {
			speed += 20;
			alarm.setPeriod(speed);			//slows program
		}

		//check to see if max button is being clicked
		else if (fasterButton.isInside(lastX, lastY)) {
			if(speed > 21)
				speed -= 20;			//hastens program
		}
		//check to see if min button is being clicked
		else if (throwButton.isInside(lastX, lastY)) {
			myCollection.add(new Ball());					//adds a new ball
			if(!running)
				running = true;							//start game
		}
		//check to see if removed button is being clicked
		else if(removeButton.isInside(lastX, lastY)) {
			myCollection.remove();					//removes a random ball
		}

		else if(resetButton.isInside(lastX, lastY)) {
			myCollection.reset();					//restarts program

			if(running)
				running = false;				//stops alarm
			speed = 100;						//resets program speed
			
		}

		
	}//check


	//The only "graphical" method of the class is the paint method.
	public void paint(Graphics pane){
		if(slowerButton != null)
			slowerButton.paint(pane);

		if(fasterButton != null)
			fasterButton.paint(pane);			//if the button is not
													//null then paint it
		if(throwButton != null)
			throwButton.paint(pane);

		if(removeButton != null)
			removeButton.paint(pane);

		if(resetButton != null)
			resetButton.paint(pane);

		pane.drawLine(50, 100, 50, 600);
		pane.drawLine(50, 600, 550, 600);	// outline of box
		pane.drawLine(550, 100, 550, 600);

		myCollection.paint(pane);//paint myCollection (balls)

	}//paint


	public void mouseClicked(MouseEvent event){
		//call the check method when event mouseClicked is triggered
		check();							//	Handle the mouse click
	}//mouesClicked

	
	public void mousePressed(MouseEvent event){
		//keep track of where mouse location was clicked
		lastX = event.getX();				//	Update the mouse location
		lastY = event.getY();

		flipWhenInside();					//	Flip any button hit by the mouse
	}//mousePressed

	
	public void mouseReleased(MouseEvent event){
		//flip button when pressed
		flipWhenInside();
	}//mouseReleased

	
	//required for mouseListener
	public void mouseEntered(MouseEvent event) {}
	public void mouseExited(MouseEvent event) {}


	/**
	 * This method is used to "flip" the button it is clicked
	 */
	private void flipWhenInside()
	{
		if (slowerButton.isInside(lastX, lastY))
			slowerButton.flip();

		else if (fasterButton.isInside(lastX, lastY))
			fasterButton.flip();

		else if (throwButton.isInside(lastX, lastY))
			throwButton.flip();
		else if (resetButton.isInside(lastX, lastY))
			resetButton.flip();
		else if (removeButton.isInside(lastX, lastY))
			removeButton.flip();

		repaint();
	}//flipWhenInside

	
	//for the alarm
	public void takeNotice() {
		if(running){
			myCollection.update();
			this.repaint();
		}
	}//takeNotice

	
}//End DataOrganizer
