import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;


public abstract class Player {

	private String name;
	private int health, maxHealth;
	private float x,y;
	protected SpriteSheet sheet;
	protected Image image;
	protected Animation moveRightAnim, moveLeftAnim, moveDownAnim, moveUpAnim;
	private static double WALKSPEED = 0.003;

	public Player(String name, int x, int y){
		this.name = name;
		this.x = x;
		this.y = y;
	}

	public void attack(){
		
	}

	public void moveRight(){
		x+=WALKSPEED;
	}
	public void moveLeft(){
		x-=WALKSPEED;
	}
	public void moveDown(){
		y+=WALKSPEED;
	}
	public void moveUp(){
		y-=WALKSPEED;
	}
	
	public Image getImage(){
		return image;
	}
	public double getSpeed(){
		return WALKSPEED;
	}
	
	public float getX(){
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
	public float getY(){
		return y;
	}
	public void setHealth(int health){
		this.health = health;
	}
	public Animation getAnimation(){
		return moveRightAnim;
	}


}
