
/**
 * 
 * @author Created by Jason Komoda, Chris Tracy, and Tresdon Jones, students at DU. For their final project in COMP 2673
 * 
 *  Represents a camera that follows the player as he moves.
 */
public class Camera {
	
	private int x;
	private int y;
	
	/**
	 * constructor that creates a new camera at a specified x and y coordinate
	 * @param x - x value
	 * @param y - y value
	 */
	public Camera(int x, int y){
		this.x = -x;
		this.y = -y;
	}
	
	/**
	 * gets the x coordinate of the camera
	 * @return - x value of camera
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * gets the y coordinate of the camera
	 * @return - y value of camera
	 */
	public int getY(){
		return y;
	}
	
	/**
	 * sets y coordinate of the camera
	 * @param val - specified value of y
	 */
	public void setY(int val){
		y = val;
	}
	
	/**
	 * sets x coordinate of the camera
	 * @param val - specified value of x
	 */
	public void setX(int val){
		x = val;
	}
	
	/**
	 * moves the camera up
	 */
	public void moveUp(){
		y+=50;
	}
	
	/**
	 * moves the camera down
	 */
	public void moveDown(){
		y-=50;
	}
	
	/**
	 * moves the camera left
	 */
	public void moveLeft(){
		x+=50;
	}
	
	/**
	 * moves the camera right
	 */
	public void moveRight(){
		x-=50;
	}
}
