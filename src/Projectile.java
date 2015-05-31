import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public class Projectile {
	private double myX;
	private double myY;
	private String direction;
	private static double mySpeed=.02;
	private Image image;
	private boolean isVisible;

	public Projectile(double startX, double startY,String dir) throws SlickException{
		image = new Image("res/arrow.png");
		myX = startX;
		myY = startY;
		direction = dir;
		switch(direction){
		case "right": image.setRotation(45);break;
		case "left"	: image.setRotation(-135);break;
		case "up"	: image.setRotation(-45);break;
		case "down"	: image.setRotation(135);break;
		}
		isVisible = true;
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
