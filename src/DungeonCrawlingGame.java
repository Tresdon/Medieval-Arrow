import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

/**
 * 
 * @author Created by Jason Komoda, Chris Tracy, and Tresdon Jones, students at DU. For their final project in COMP 2673
 * 
 * ----------------------------             Medevial Arrow          ------------------------------------------------------
 * 
 * A small game that utilizes the slick2d graphics wrapper and consists of fighting pretty sporadic skeletons!
 * 
 * This is the main state where the games runs everything implemented so far, we planned on making a main menu, a pause menu and the like, but we did not completed those things.
 * 
 *
 */
public class DungeonCrawlingGame extends StateBasedGame {
	
	/**
	 * constructor that creates a new game with a title
	 * @param title - title of the game
	 */
	public DungeonCrawlingGame(String title) {
		super(title);
	}

	/**
	 * main method that helps create a new game
	 * @param args -
	 * @throws SlickException - exception that specifies the issue is related to slick2d game library
	 */
	public static void main(String[] args) throws SlickException  {
		DungeonCrawlingGame game = new DungeonCrawlingGame("Medevial Arrow");
		AppGameContainer app = new AppGameContainer(game);
		app.setDisplayMode(app.getScreenWidth(),app.getScreenHeight(),true);
		app.setIcon("res/icons/32x32.png");
		app.start();
		app.setShowFPS(false);

		
		
	}

	/**
	 * adds a game state to help create the game
	 */
	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		this.addState(new GameState());
	}
		
		
	

}
