import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

import java.util.Random;


public class Enemy {
	private int y,x;
	private int health, maxHealth;
	protected Animation moveRightAnim, moveLeftAnim, moveDownAnim, moveUpAnim, animation,
						shootRightAnim, shootLeftAnim, shootDownAnim, shootUpAnim;
	private static int WALKSPEED = 50;
	private String direction="right";
	private Random rand;
	public Enemy(int x,int y){
		this.x=x;
		this.y=y;
		health = 15;
		maxHealth = 15;
		rand = new Random();
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
		x+=WALKSPEED;
		animation = moveRightAnim;
		direction = "right";
	}
	public void moveLeft(){
		x-=WALKSPEED;
		animation = moveLeftAnim;
		direction = "left";
	}
	public void moveDown(){
		y+=WALKSPEED;
		animation = moveDownAnim;
		direction = "down";

	}
	public void moveUp(){
		y-=WALKSPEED;
		animation = moveUpAnim;
		direction = "up";
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
	public int randomAttack() throws SlickException{
		int num = rand.nextInt(1000);
		return num;
	
	}
	public static Enemy factory(int x, int y){
		return new Enemy(x,y);
	}
	public String toString(){
		return "X: " +x +"Y: "+ y;
	}
	public boolean checkRight(TiledMap dungeon){
		int wallLayer = dungeon.getLayerIndex("wall");
		if(dungeon.getTileId((x/50)+1,(y/50),wallLayer)==0){
			moveRight();
			return true;
		}
		else{
			return false;
		}	}
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
	public boolean checkDown(TiledMap dungeon){
		int wallLayer = dungeon.getLayerIndex("wall");
		if(dungeon.getTileId((x/50),(y/50)+1,wallLayer)==0){
			moveDown();
			return true;
		}
		else{
			return false;
		}	}
	public boolean checkLeft(TiledMap dungeon){
		int wallLayer = dungeon.getLayerIndex("wall");
		if(dungeon.getTileId((x/50)-1,(y/50),wallLayer)==0){
			moveLeft();
			return true;
		}
		else{
			return false;
		}	}
	public void setHealth(int health){
		if(this.health-health<=0){
			this.health=0;
		}
		else{
			this.health -=health;
		}
	}
	
	
}
