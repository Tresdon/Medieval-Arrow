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
		player = new Warrior("Tresdon",200,200);
		//Music music = new Music("res/music.ogg");
		dungeon = new TiledMap("res/dungeon-one.tmx");
		//music.play();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)	throws SlickException {
		dungeon.render(0,0);
		player.getAnimation().draw(player.getX(),player.getY());
		g.drawString("X: "+player.getX(), 200, 150);
		g.drawString("Y: "+player.getY(), 200, 200);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input keyboard = gc.getInput();
		int wallLayer = dungeon.getLayerIndex("wall");;
		if(keyboard.isKeyPressed(Input.KEY_ESCAPE)){
			gc.exit();
		}
		try{
			if(keyboard.isKeyDown(Input.KEY_W)){
				if(dungeon.getTileId(((int)player.getX()/50),((int)player.getY()/50)-1,wallLayer)==0){
					player.moveUp();
				}
			}
			else if(keyboard.isKeyDown(Input.KEY_A)){
				if(dungeon.getTileId(((int)player.getX()/50)-1,(int)player.getY()/50,wallLayer)==0){
					player.moveLeft();
				}	
			}
			else if(keyboard.isKeyDown(Input.KEY_S)){
				if(dungeon.getTileId((int)player.getX()/50,((int)player.getY())/50+1,wallLayer)==0){
					player.moveDown();
				}		
			}
			else if(keyboard.isKeyDown(Input.KEY_D)){
				if(dungeon.getTileId(((int)player.getX()/50)+1,(int)player.getY()/50,wallLayer)==0){
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
	public void movePlayerRight(){
		player.moveRight();
	}
	public void movePlayerLeft(){
		player.moveLeft();
	}
	public void movePlayerDown(){
		player.moveDown();
	}
	public void movePlayerUp(){
		player.moveUp();
	}

}
