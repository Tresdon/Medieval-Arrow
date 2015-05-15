import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class GameState extends BasicGameState {

	private Player player;
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		player = new Warrior("Tresdon",300,300);
		Music music = new Music("res/music.ogg");
		music.play();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)	throws SlickException {
		player.getAnimation().draw(player.getX(),player.getY());
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input keyboard = gc.getInput();
		if(keyboard.isKeyPressed(Input.KEY_ESCAPE)){
			gc.exit();
		}
		if(keyboard.isKeyDown(Input.KEY_W)){
			player.moveUp();
		}
		if(keyboard.isKeyDown(Input.KEY_A)){
			player.moveLeft();
		}
		if(keyboard.isKeyDown(Input.KEY_S)){
			player.moveDown();
		}
		if(keyboard.isKeyDown(Input.KEY_D)){
			player.moveRight();
		}
	}

	@Override
	public int getID() {
		return 1;
	}

}
