import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import java.util.Random;


/**
 * 
 * @author Created by Jason Komoda, Chris Tracy, and Tresdon Jones, students at DU. For their final project in COMP 2673
 * 
 * Represents a generic enemy that the player can fight.
 *
 */
public class Enemy {
	private int y,x;
	private int health, maxHealth;
	protected Animation moveRightAnim, moveLeftAnim, moveDownAnim, moveUpAnim, animation,
						shootRightAnim, shootLeftAnim, shootDownAnim, shootUpAnim;
	private static int WALKSPEED = 50;
	private String direction="right";
	private Random rand;
	
	/**
	 * constructor that creates a new enemy at a specified x and y coordinate
	 * @param x - x value
	 * @param y - y value
	 */
	public Enemy(int x,int y){
		this.x=x;
		this.y=y;
		health = 15;
		maxHealth = 15;
		rand = new Random();
	}
	
	/**
	 * creates a way for the enemy to attack
	 * @return - an enemy projectile
	 * @throws SlickException
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
	 * enemy walks right
	 */
	public void moveRight(){
		x+=WALKSPEED;
		animation = moveRightAnim;
		direction = "right";
	}
	
	/**
	 * enemy walks left
	 */
	public void moveLeft(){
		x-=WALKSPEED;
		animation = moveLeftAnim;
		direction = "left";
	}
	
	/**
	 * enemy walks down
	 */
	public void moveDown(){
		y+=WALKSPEED;
		animation = moveDownAnim;
		direction = "down";

	}
	
	/**
	 * enemy walks up
	 */
	public void moveUp(){
		y-=WALKSPEED;
		animation = moveUpAnim;
		direction = "up";
	}
	
	/**
	 * gets the x coordinate of the enemy
	 * @return - x value
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * gets the health of the enemy
	 * @return - enemy's health value
	 */
	public double getHealth(){
		return health;
	}
	
	/**
	 * gets the max health of the enemy
	 * @return - enemy's max health value
	 */
	public double getMaxHealth(){
		return maxHealth;
	}
	
	/**
	 * gets the y coordinate of the enemy
	 * @return - y value
	 */
	public int getY(){
		return y;
	}
	
	/**
	 * gets the animation of the enemy
	 * @return - enemy's animation
	 */
	public Animation getAnimation(){
		return animation;
	}

	/**
	 * creates random movement for the enemy
	 */
	public void randomMovement() {
	
		int num = rand.nextInt(1000);
		if(num==1){
			checkRight(GameState.dungeon);
		}
		if(num==2){
			checkLeft(GameState.dungeon);
		}
		if(num==3){
			checkUp(GameState.dungeon);
		}
		if(num==4){
			checkDown(GameState.dungeon);
		}
	}
	
	/**
	 * creates random attacks for the enemy
	 * @return - random number
	 * @throws SlickException - exception that specifies the issue is related to slick2d game library
	 */
	public int randomAttack() throws SlickException{
		int num = rand.nextInt(100);
		return num;
	
	}
	
	/**
	 * creates a new enemy at the specified location
	 * @param x - x coordinate
	 * @param y - y coordinate
	 * @return
	 */
	public static Enemy factory(int x, int y){
		return new Enemy(x,y);
	}
	
	public String toString(){
		return "X: " +x +"Y: "+ y;
	}
	
	/**
	 * checks if there is space to the right of the enemy
	 * @param dungeon - map of tiles
	 * @return - true if there is space, false otherwise
	 */
	public boolean checkRight(TiledMap dungeon){
		int wallLayer = dungeon.getLayerIndex("wall");
		if(dungeon.getTileId((x/50)+1,(y/50),wallLayer)==0){
			moveRight();
			return true;
		}
		else{
			return false;
		}	}
	
	/**
	 * checks if there is space above the enemy
	 * @param dungeon - map of tiles
	 * @return - true if there is space, false otherwise
	 */
	public boolean checkUp(TiledMap dungeon){
		int wallLayer = dungeon.getLayerIndex("wall");
		if(dungeon.getTileId((x/50),(y/50)-1,wallLayer)==0){
			moveUp();
			return true;
		}
		else{
			return false;
		}
	}
	
	/**
	 * checks if there is space below the enemy
	 * @param dungeon - map of tiles
	 * @return - true if there is space, false otherwise
	 */
	public boolean checkDown(TiledMap dungeon){
		int wallLayer = dungeon.getLayerIndex("wall");
		if(dungeon.getTileId((x/50),(y/50)+1,wallLayer)==0){
			moveDown();
			return true;
		}
		else{
			return false;
		}	}
	
	/**
	 * checks if there is space to the left of the enemy
	 * @param dungeon - map of tiles
	 * @return - true if there is space, false otherwise
	 */
	public boolean checkLeft(TiledMap dungeon){
		int wallLayer = dungeon.getLayerIndex("wall");
		if(dungeon.getTileId((x/50)-1,(y/50),wallLayer)==0){
			moveLeft();
			return true;
		}
		else{
			return false;
		}	}
	
	/**
	 * sets the health of the enemy
	 * @param health - specified value of health
	 */
	public void setHealth(int health){
		if(this.health-health<=0){
			this.health=0;
		}
		else{
			this.health -=health;
		}
	}
	
	
}
