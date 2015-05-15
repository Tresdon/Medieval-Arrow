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
	private static final double WALKSPEED = 0.1;

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
	
	public float getX(){
		return x;
	}
	public float getY(){
		return y;
	}
	public Animation getAnimation(){
		return moveRightAnim;
	}


}
