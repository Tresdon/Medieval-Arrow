import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;


public class GameState extends BasicGameState {

	private TiledMap map;
	private Player player;
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		player = new Warrior("Tresdon",50,50);
		//Music music = new Music("res/music.ogg");
		map = new TiledMap("res/dungeon.tmx");
		//music.play();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)	throws SlickException {
		map.render(0,0);
		player.getAnimation().draw(player.getX(),player.getY());
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input keyboard = gc.getInput();
		int wallLayer = map.getLayerIndex("wall");;
		int bgLayer = map.getLayerIndex("background");
		if(keyboard.isKeyPressed(Input.KEY_ESCAPE)){
			gc.exit();
		}
		try{
		if(keyboard.isKeyDown(Input.KEY_W)){
			if(map.getTileId(((int)player.getX()/50),((int)player.getY()/50)-1,bgLayer)==1){
				player.moveUp();
			}
		}
		if(keyboard.isKeyDown(Input.KEY_A)){
			if(map.getTileId(((int)player.getX()/50)-1,(int)player.getY()/50,bgLayer)==1){
				player.moveLeft();
			}	
		}
		if(keyboard.isKeyDown(Input.KEY_S)){
			if(map.getTileId((int)player.getX()/50,((int)player.getY())/50+1,bgLayer)==1){
				player.moveDown();
			}		
		}
		if(keyboard.isKeyDown(Input.KEY_D)){
			if(map.getTileId(((int)player.getX()/50)+1,(int)player.getY()/50,bgLayer)==1){
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
