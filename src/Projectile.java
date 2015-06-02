import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Projectile {
	private double myX;
	private double myY;
	private double origX;
	private double origY;
	private String direction;
	private static double mySpeed=.05;
	private Image image;
	
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

	public boolean hitPlayer(Player aPlayer){
		if(myX >= aPlayer.getX() - 1 && myX <= aPlayer.getX() + 1){
			if(myY <= aPlayer.getY() + 1 && myY >= aPlayer.getY() - 1){
				return true;
			}
		}
		return false;
	}
	public boolean hitEnemy(Enemy enemy){
		if(myX >= enemy.getX() - 25 && myX <= enemy.getX() + 25){
			if(myY <= enemy.getY() + 25 && myY >= enemy.getY() - 25){
				return true;
			}
		}
		return false;
	}
	
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

	public double getX(){
		return myX;
	}

	public double getY(){
		return myY;
	}
	public Image getImage(){
		return image;
	}
	public void shoot(){
		switch(direction){
		case "right": myX+=mySpeed;break;
		case "left"	: myX-=mySpeed;break;
		case "up"	: myY-=mySpeed;break;
		case "down"	: myY+=mySpeed;break;
		}
	}
	
}
