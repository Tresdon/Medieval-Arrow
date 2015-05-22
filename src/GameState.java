import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;


public class GameState extends BasicGameState {

	private TiledMap dungeon;
	private Player player;
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		player = new Warrior("Tresdon",gc.getWidth()/2,gc.getWidth()/2);
		//Music music = new Music("res/music.ogg");
		dungeon = new TiledMap("res/dungeon.tmx");
		//music.play();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)	throws SlickException {
		dungeon.render(0,0,(int)player.getX()-gc.getWidth()/2,(int)player.getY()-gc.getWidth()/2,40,30);
		player.getAnimation().draw(gc.getWidth()/2,gc.getHeight()/2);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input keyboard = gc.getInput();
		int wallLayer = dungeon.getLayerIndex("wall");;
		int bgLayer = dungeon.getLayerIndex("background");
		if(keyboard.isKeyPressed(Input.KEY_ESCAPE)){
			gc.exit();
		}
		try{
			if(keyboard.isKeyDown(Input.KEY_W)){
				if(dungeon.getTileId(((int)player.getX()/50),((int)player.getY()/50)-1,bgLayer)==1){
					player.moveUp();
				}
			}
			if(keyboard.isKeyDown(Input.KEY_A)){
				if(dungeon.getTileId(((int)player.getX()/50)-1,(int)player.getY()/50,bgLayer)==1){
					player.moveLeft();
				}	
			}
			if(keyboard.isKeyDown(Input.KEY_S)){
				if(dungeon.getTileId((int)player.getX()/50,((int)player.getY())/50+1,bgLayer)==1){
					player.moveDown();
				}		
			}
			if(keyboard.isKeyDown(Input.KEY_D)){
				if(dungeon.getTileId(((int)player.getX()/50)+1,(int)player.getY()/50,bgLayer)==1){
					player.moveRight();
				}		
			}
		}
		catch(Exception e){

		}

	}

	@Override
	public int getID() {
		return 1;
	}

}
