import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Image;

public class Warrior extends Player {


	public Warrior(int x, int y) throws SlickException {
		super(x, y);
	
	}

	public void moveRight(){
		super.moveRight();
		animation.start();
	}
	public void moveLeft(){
		super.moveLeft();
		animation.stop();
	}
	public void moveUp(){
		super.moveUp();
	}
	public void moveDown(){
		super.moveDown();
	}
	public Animation getAnimation(){
		return animation;
	}


}
