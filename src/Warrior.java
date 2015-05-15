import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Image;

public class Warrior extends Player {

	private Image[] moveRightImages = new Image[5];
	public Warrior(String name, int x, int y) throws SlickException {
		super(name, x, y);
		sheet = new SpriteSheet("res/warriorsheet.png",30,30);
		image = sheet.getSubImage(0,0);
		moveRightAnim = new Animation();
		for(int i= 0;i<5;i++){
			moveRightAnim.addFrame(sheet.getSubImage(i,1),220);
		}
		
	}

	public void moveRight(){
		super.moveRight();
		moveRightAnim.start();
		image = moveRightAnim.getCurrentFrame();
	}
	public void moveLeft(){
		super.moveLeft();
	}
	public void moveUp(){
		super.moveUp();
	}
	public void moveDown(){
		super.moveDown();
		image = sheet.getSubImage(2, 4);
	}
	public Animation getAnimation(){
		return moveRightAnim;
	}


}
