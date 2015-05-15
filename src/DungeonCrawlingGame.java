import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class DungeonCrawlingGame extends StateBasedGame {
	
	public DungeonCrawlingGame(String title) {
		super(title);
	}

	public static void main(String[] args) throws SlickException  {
		DungeonCrawlingGame game = new DungeonCrawlingGame("Dungeon Crawling Game");
		AppGameContainer app = new AppGameContainer(game);
		app.setDisplayMode(app.getScreenWidth()/2,app.getScreenHeight()/2,false);
		app.start();
		
	}

	@Override
	public void initStatesList(GameContainer arg0) throws SlickException {
		this.addState(new GameState());
	}
		
		
	

}