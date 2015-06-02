import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

/**
 * 
 * @author Created by Jason Komoda, Chris Tracy, and Tresdon Jones, students at DU. For their final project in COMP 2673
 * 
 * Represents a skeleton, a specific enemy that the player can fight.
 *
 */
public class Skeleton extends Enemy {

	/**
	 * constructor that creates a new enemy skeleton at a specified x and y coordinate
	 * @param x - x value
	 * @param y - y value
	 * @throws SlickException - exception that specifies the issue is related to slick2d game library
	 */
	public Skeleton(int x, int y) throws SlickException {
		super(x, y);
		moveDownAnim = new Animation(
				new SpriteSheet(
				new Image("res/skeleton/walkDown.png"),
				64,64),100);
		moveLeftAnim = new Animation(
				new SpriteSheet(
				new Image("res/skeleton/walkLeft.png"),
				64,64),100);
		moveUpAnim = new Animation(
				new SpriteSheet(
				new Image("res/skeleton/walkUp.png"),
				64,64),100);
		moveRightAnim = new Animation(
				new SpriteSheet(
				new Image("res/skeleton/walkRight.png"),
				64,64),100);
		shootDownAnim = new Animation(
				new SpriteSheet(
				new Image("res/skeleton/shootDown.png"),
				64,64),50);
		shootLeftAnim = new Animation(
				new SpriteSheet(
				new Image("res/skeleton/shootLeft.png"),
				64,64),50);
		shootUpAnim = new Animation(
				new SpriteSheet(
				new Image("res/skeleton/shootUp.png"),
				64,64),50);
		shootRightAnim = new Animation(
				new SpriteSheet(
				new Image("res/skeleton/shootRight.png"),
				64,64),50);
		animation = moveRightAnim;	
	}

}
