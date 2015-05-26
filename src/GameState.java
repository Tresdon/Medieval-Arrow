import org.newdawn.slick.Color;
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
	private Camera camera;
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		player = new Warrior("Tresdon",200,200);
		//Music music = new Music("res/music.ogg");
		dungeon = new TiledMap("res/dungeon-one.tmx");
		//music.play();
		camera = new Camera(player.getX()+250,player.getY());
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)	throws SlickException {
		g.translate(camera.getX(), camera.getY());
		dungeon.render(0,0);
		player.getAnimation().draw(player.getX(),player.getY());
		g.setColor(Color.black);
		g.fillRect(player.getX()-100, player.getY()+320, player.getMaxHealth()*3, 50);
		if(player.getHealth()>=player.getMaxHealth()/3*2){
			g.setColor(Color.green);
		}
		else if(player.getHealth()>=player.getMaxHealth()/3){
			g.setColor(Color.orange);
		}
		else{
			g.setColor(Color.red);
		}
		g.fillRect(player.getX()-100, player.getY()+320, player.getHealth()*3, 50);

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input keyboard = gc.getInput();
		int wallLayer = dungeon.getLayerIndex("wall");;
		if(keyboard.isKeyPressed(Input.KEY_ESCAPE)){
			gc.exit();
		}
		try{
			if(keyboard.isKeyPressed(Input.KEY_W)){
				if(dungeon.getTileId(((int)player.getX()/50),((int)player.getY()/50)-1,wallLayer)==0){
					player.moveUp();
					camera.moveUp();
				}
			}
			else if(keyboard.isKeyPressed(Input.KEY_A)){
				if(dungeon.getTileId(((int)player.getX()/50)-1,(int)player.getY()/50,wallLayer)==0){
					player.moveLeft();
					camera.moveLeft();
				}	
			}
			else if(keyboard.isKeyPressed(Input.KEY_S)){
				if(dungeon.getTileId((int)player.getX()/50,((int)player.getY())/50+1,wallLayer)==0){
					player.moveDown();
					camera.moveDown();
				}		
			}
			else if(keyboard.isKeyPressed(Input.KEY_D)){
				if(dungeon.getTileId(((int)player.getX()/50)+1,(int)player.getY()/50,wallLayer)==0){
					player.moveRight();
					camera.moveRight();
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
