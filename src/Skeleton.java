import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;


public class Skeleton extends Enemy {

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
		animation = moveRightAnim;	
	}

}
