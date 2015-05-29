import java.util.ArrayList;
import java.util.Arrays;

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

	public static TiledMap dungeon;
	private Player player;
	private Camera camera;
	private ArrayList<Skeleton> enemies;
	private ArrayList<Projectile> projectiles;
	private Skeleton skelly;
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		dungeon = new TiledMap("res/dungeon-one.tmx");
		//Music music = new Music("res/music.ogg");
		//music.play();
		//music.setVolume((float)0.3);
		camera = new Camera(100,300);
		player = new Archer(900,800);
		enemies = new ArrayList<Skeleton>();
		projectiles = new ArrayList<Projectile>();
		//		for(int i =1 ; i<10 ; i++){
		//			enemies.add(new Skeleton(i*300,i*500));
		//		}
		skelly = new Skeleton(1000,800);

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)	throws SlickException {
		g.translate(camera.getX(), camera.getY());
		dungeon.render(0,0);
		if(player.isWalking()){
			player.getAnimation().draw(player.getX(),player.getY(),50,50);
		}
		else{
			player.getImage().draw(player.getX(),player.getY(),50,50);
		}

		skelly.getAnimation().draw(skelly.getX(),skelly.getY(),50,50);
		//		for(Enemy enemy: enemies){
		//			enemy.getAnimation().draw(enemy.getX(),enemy.getY(),50,50);
		//		}

		//DRAW HEALTH BARS
		g.setColor(Color.black);
		g.fillRect(player.getX()-32, player.getY()-20, (int)player.getMaxHealth(), 20);

		if(player.getHealth()>=player.getMaxHealth()/3*2){
			g.setColor(Color.green);
		}
		else if(player.getHealth()>=player.getMaxHealth()/3){
			g.setColor(Color.orange);
		}
		else{
			g.setColor(Color.red);
		}
		g.fillRect(player.getX()-32, player.getY()-20, (int)player.getHealth(),20);

		for(int i = 0; i < projectiles.size(); i++){
			Projectile temp = projectiles.get(i);
			for(int j =0;j<40;j++){
				temp.shoot();
				temp.getImage().draw((float)temp.getX(),(float)temp.getY());
			}
		}

	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		Input keyboard = gc.getInput();
		keyboard.enableKeyRepeat();
		int wallLayer = dungeon.getLayerIndex("wall");
		int healthLayer = dungeon.getLayerIndex("health");
		if(keyboard.isKeyPressed(Input.KEY_ESCAPE)){
			gc.exit();
		}
		if(keyboard.isKeyPressed(Input.KEY_SPACE)){
			projectiles.add(player.attack());
		}
		//		for(int i = 0;i<enemies.size();i++){
		//			enemies.get(i).randomMovement();
		//		}
		skelly.randomMovement();
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
			else{
			}
		}
		catch(Exception e){

		}
		if(!(dungeon.getTileId((int)player.getX()/50, (int)player.getY()/50, healthLayer)==0)){
			player.heal();
		}
	}

	@Override
	public int getID() {
		return 1;
	}


}
