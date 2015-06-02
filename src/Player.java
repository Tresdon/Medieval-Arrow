import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


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

	public Player(int x, int y){
		this.x = x;
		this.y = y;
		health = 100;
		maxHealth = 100;
		walking = false;
		direction = "right";
	}

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

	public void moveRight(){
			walking = true;
			x+=WALKSPEED;
			animation = moveRightAnim;
			direction = "right";
			idle = rightIdle;
	}
	public void moveLeft(){
			walking = true;
			x-=WALKSPEED;
			animation = moveLeftAnim;
			direction = "left";
			idle = leftIdle;
	}
	public void moveDown(){
			walking = true;
			y+=WALKSPEED;
			animation = moveDownAnim;
			direction = "down";
			idle = downIdle;
	}
	public void moveUp(){
			walking = true;
			y-=WALKSPEED;
			animation = moveUpAnim;
			direction = "up";
			idle = upIdle;
	}

	public int getX(){
		return x;
	}
	public double getHealth(){
		return health;
	}
	public double getMaxHealth(){
		return maxHealth;
	}
	public int getY(){
		return y;
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

	public void heal(){
		if(health<maxHealth){
			health += .1;
		}
	}
	public void setHealth(int health){
		if(this.health-health<=0){
			this.health=0;
		}
		else{
			this.health -=health;
		}
	}
	public void setWalking(boolean val){
		walking = val;
	}
	public void setDead(boolean val){
		dead = val;
	}
	public boolean getDead(){
		return dead;
	}
	public void die(){
		animation = deadAnim;
	}


}
