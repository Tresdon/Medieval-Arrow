import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

/**
 * 
 * @author Created by Jason Komoda, Chris Tracy, and Tresdon Jones, students at DU. For their final project in COMP 2673
 * 
 * Has the logic for any kind of projectile, the only projectile we used was an arrow for now, but it can easily spawn all kinds of projectiles.
 *
 */
public class Projectile {
	private double myX;
	private double myY;
	private double origX;
	private double origY;
	private String direction;
	private static double mySpeed=.05;
	private Image image;
	
	/**
	 * constructor that creates a new projectile at a specified value
	 * @param startX - starting x value
	 * @param startY - starting y value
	 * @param dir - direction the projectile is moving in 
	 * @throws SlickException - exception that specifies the issue is related to slick2d game library
	 */
	public Projectile(double startX, double startY,String dir) throws SlickException{
		image = new Image("res/arrow.png");
		myX = startX;
		myY = startY;
		origX = startX;
		origY = startY;
		direction = dir;
		switch(direction){
		case "right": image.setRotation(45);break;
		case "left"	: image.setRotation(-135);break;
		case "up"	: image.setRotation(-45);break;
		case "down"	: image.setRotation(135);break;
		}
	}

	/**
	 * determines whether a projectile hits a player
	 * @param aPlayer - player the projectile hits 
	 * @return - true if player gets hit, false otherwise
	 */
	public boolean hitPlayer(Player aPlayer){
		if(myX >= aPlayer.getX() - 1 && myX <= aPlayer.getX() + 1){
			if(myY <= aPlayer.getY() + 1 && myY >= aPlayer.getY() - 1){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * determines whether a projectile hits an enemy
	 * @param enemy - enemy projectile hits
	 * @return - true if enemy gets hit, false otherwise
	 */
	public boolean hitEnemy(Enemy enemy){
		if(myX >= enemy.getX() - 25 && myX <= enemy.getX() + 25){
			if(myY <= enemy.getY() + 25 && myY >= enemy.getY() - 25){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * checks a projectile is visible or not
	 * @param projectiles - list of projectiles
	 */
	public static void checkVisible(ArrayList<Projectile> projectiles){
		ArrayList<Projectile> projectilesCopy = new ArrayList<Projectile>(projectiles);
		for(Projectile proj: projectilesCopy){
			if(proj.myX>proj.origX+300&&proj.direction.equals("right")||
					proj.myX<proj.origX-300&&proj.direction.equals("left")||
					proj.myY>proj.origY+300&&proj.direction.equals("down")||
					proj.myY<proj.origY-300&&proj.direction.equals("up")){
				projectiles.remove(proj);
			}
		}
	}

	/**
	 * gets x coordinate of projectile
	 * @return - x value
	 */
	public double getX(){
		return myX;
	}

	/**
	 * gets y coordinate of projectile
	 * @return - y value
	 */
	public double getY(){
		return myY;
	}
	
	/**
	 * gets image of projectile
	 * @return - image of projectile
	 */
	public Image getImage(){
		return image;
	}
	
	/**
	 * shoots projectile in a certain direction
	 */
	public void shoot(){
		switch(direction){
		case "right": myX+=mySpeed;break;
		case "left"	: myX-=mySpeed;break;
		case "up"	: myY-=mySpeed;break;
		case "down"	: myY+=mySpeed;break;
		}
	}
	
}
