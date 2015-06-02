import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * 
 * @author Created by Jason Komoda, Chris Tracy, and Tresdon Jones, students at DU. For their final project in COMP 2673
 * 
 * Represents a playable character.
 *
 */
public abstract class Player {

	private double health, maxHealth;
	private int x,y;
	protected Animation moveRightAnim, moveLeftAnim, moveDownAnim, moveUpAnim, animation,
	shootRightAnim, shootLeftAnim, shootDownAnim, shootUpAnim, deadAnim;
	protected Image idle, rightIdle, downIdle, upIdle, leftIdle;
	protected String direction;
	private boolean walking=false;
	private boolean dead = false;
	private static int WALKSPEED = 50;

	/**
	 * constructor that creates a new player at specified x and y coordinate
	 * @param x - x value
	 * @param y - y value
	 */
	public Player(int x, int y){
		this.x = x;
		this.y = y;
		health = 100;
		maxHealth = 100;
		walking = false;
		direction = "right";
	}

	/**
	 * creates a way for the player to attack
	 * @return - a player projectile
	 * @throws SlickException - exception that specifies the issue is related to slick2d game library
	 */
	public Projectile attack() throws SlickException{
		Projectile proj = new Projectile(x,y,direction);
		switch(direction){
		case "right": animation = shootRightAnim;break;
		case "left"	: animation = shootLeftAnim;break;
		case "up"	: animation = shootUpAnim;break;
		case "down"	: animation = shootDownAnim;break;
		}
		return proj;
	}

	/**
	 * player walks right
	 */
	public void moveRight(){
			walking = true;
			x+=WALKSPEED;
			animation = moveRightAnim;
			direction = "right";
			idle = rightIdle;
	}
	
	/**
	 * player walks left
	 */
	public void moveLeft(){
			walking = true;
			x-=WALKSPEED;
			animation = moveLeftAnim;
			direction = "left";
			idle = leftIdle;
	}
	
	/**
	 * player walks down
	 */
	public void moveDown(){
			walking = true;
			y+=WALKSPEED;
			animation = moveDownAnim;
			direction = "down";
			idle = downIdle;
	}
	
	/**
	 * player walks up
	 */
	public void moveUp(){
			walking = true;
			y-=WALKSPEED;
			animation = moveUpAnim;
			direction = "up";
			idle = upIdle;
	}

	/**
	 * gets x coordinate of player
	 * @return - x value
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * gets current health of player
	 * @return - return health value
	 */
	public double getHealth(){
		return health;
	}
	
	/**
	 * gets max health of player
	 * @return - max health value
	 */
	public double getMaxHealth(){
		return maxHealth;
	}
	
	/**
	 * gets y coordinate of player
	 * @return - y value
	 */
	public int getY(){
		return y;
	}
	
	/**
	 * gets animation of player
	 * @return - animation of player
	 */
	public Animation getAnimation(){
		return animation;
	}
	
	/**
	 * gets image of player
	 * @return - idle image of player
	 */
	public Image getImage(){
		return idle;
	}
	
	/**
	 * determines whether a player is walking or not
	 * @return - true if walking, false otherwise
	 */
	public boolean isWalking(){
		return walking;
	}

	/**
	 * increases the player's health
	 */
	public void heal(){
		if(health<maxHealth){
			health += 1;
		}
	}
	
	/**
	 * subtracts specified value of health from the player
	 * @param health - value of health
	 */
	public void setHealth(int health){
		if(this.health-health<=0){
			this.health=0;
		}
		else{
			this.health -=health;
		}
	}
	
	/**
	 * sets the player to walk or not
	 * @param val - true or false walking value
	 */
	public void setWalking(boolean val){
		walking = val;
	}
	
	/**
	 * sets the player to be dead or not
	 * @param val - true or false dead value
	 */
	public void setDead(boolean val){
		dead = val;
	}
	
	/**
	 * determines if the player is dead or not
	 * @return - true if dead, false otherwise
	 */
	public boolean getDead(){
		return dead;
	}
	
	/**
	 * sets animation to the dead player animation
	 */
	public void die(){
		animation = deadAnim;
	}
	
	/**
	 * sets the direction the player is facing
	 * @param str - direction player is facing
	 */
	public void setDirection(String str){
		direction = str;
	}


}
