import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;


public abstract class Player {

	private int health, maxHealth;
	private int x,y;
	protected Animation moveRightAnim, moveLeftAnim, moveDownAnim, moveUpAnim, animation;
	protected Image idle, rightIdle, downIdle, upIdle, leftIdle;
	protected String facing;
	private boolean walking=false;
	private static double WALKSPEED = 50;

	public Player(int x, int y){
		this.x = x;
		this.y = y;
		health = 100;
		maxHealth = 100;
		walking = false;
	}

	public void attack(){
		
	}

	public void moveRight(){
		walking = true;
		x+=WALKSPEED;
		animation = moveRightAnim;
		idle = rightIdle;
	}
	public void moveLeft(){
		walking = true;
		x-=WALKSPEED;
		animation = moveLeftAnim;
		idle = leftIdle;
	}
	public void moveDown(){
		walking = true;
		y+=WALKSPEED;
		animation = moveDownAnim;
		idle = downIdle;

	}
	public void moveUp(){
		walking = true;
		y-=WALKSPEED;
		animation = moveUpAnim;
		idle = upIdle;
	}
	

	public double getSpeed(){
		return WALKSPEED;
	}
	
	public int getX(){
		return x;
	}
	public int getHealth(){
		return health;
	}
	public int getMaxHealth(){
		return maxHealth;
	}
	public void setSpeed(double speed){
		WALKSPEED = speed;
	}
	public int getY(){
		return y;
	}
	public void setHealth(int health){
		this.health = health;
	}
	public Animation getAnimation(){
		return animation;
	}
	public Image getImage(){
		return idle;
	}
	public boolean isWalking(){
		return walking;
	}
	public void setWalking(boolean val){
		walking = val;
	}


}
