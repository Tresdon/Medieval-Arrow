import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;


public class Archer extends Player {

	public Archer(int x, int y) throws SlickException {
		super(x, y);
		moveDownAnim = new Animation(
				new SpriteSheet(
				new Image("res/archer/walkDown.png"),
				64,64),100);
		moveLeftAnim = new Animation(
				new SpriteSheet(
				new Image("res/archer/walkLeft.png"),
				64,64),100);
		moveUpAnim = new Animation(
				new SpriteSheet(
				new Image("res/archer/walkUp.png"),
				64,64),100);
		moveRightAnim = new Animation(
				new SpriteSheet(
				new Image("res/archer/walkRight.png"),
				64,64),100);
		shootDownAnim = new Animation(
				new SpriteSheet(
				new Image("res/archer/shootDown.png"),
				64,64),50);
		shootLeftAnim = new Animation(
				new SpriteSheet(
				new Image("res/archer/shootLeft.png"),
				64,64),50);
		shootUpAnim = new Animation(
				new SpriteSheet(
				new Image("res/archer/shootUp.png"),
				64,64),50);
		shootRightAnim = new Animation(
				new SpriteSheet(
				new Image("res/archer/shootRight.png"),
				64,64),50);
		deadAnim = new Animation(
				new SpriteSheet(
				new Image("res/archer/dieStill.png"),
				63,53),50);		
		animation = moveRightAnim;		
		
		rightIdle = new Image("res/archer/idleRight.png");
		leftIdle = new Image("res/archer/idleLeft.png");
		downIdle = new Image("res/archer/idleDown.png");
		upIdle = new Image("res/archer/idleUp.png");
		idle = rightIdle;
	}


}
