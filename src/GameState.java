import java.awt.Font;
import java.util.ArrayList;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

/**
 * 
 * @author Created by Jason Komoda, Chris Tracy, and Tresdon Jones, students at DU. For their final project in COMP 2673
 * 
 * The basic game state used throughout the game.
 *
 */
public class GameState extends BasicGameState {

	/**
	 * declares some variables and data structures to hold the game's data
	 */
	public static TiledMap dungeon;
	private Player player;
	private Camera camera;
	private ArrayList<Skeleton> enemies;
	private ArrayList<Projectile> projectiles;
	private ArrayList<Projectile> enemyProjectiles;
	private ArrayList<Enemy> enemiesCopy;
	private int wallLayer;
	private int healthLayer;
	private Input keyboard;
	private TrueTypeFont font;
	private boolean gameOver = false;
	
	@Override
	/**
	 * Initializes some of the data structures and variables.
	 */
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		dungeon = new TiledMap("res/dungeon-one.tmx");
		keyboard = gc.getInput();
		keyboard.enableKeyRepeat();
		wallLayer = dungeon.getLayerIndex("wall");
		healthLayer = dungeon.getLayerIndex("health");
		Music music = new Music("res/music.ogg");
		music.play();
		music.setVolume((float)0.3);
		camera = new Camera(-400,-200);
		player = new Archer(200,200);
		enemies = new ArrayList<Skeleton>();
		projectiles = new ArrayList<Projectile>();
		enemyProjectiles = new ArrayList<Projectile>();
		
		for(int i =1 ; i<10 ; i++){
			enemies.add(new Skeleton(i*200,i*200));
		}
		for(int i =1 ; i<5 ; i++){
			enemies.add(new Skeleton(i*300,i*300));
		}

		// load a default java font
		Font awtFont = new Font("Times New Roman", Font.BOLD, 40);
		font = new TrueTypeFont(awtFont, false);



	}

	@Override
	/**
	 * Takes care of anything in the game that has to do with drawing. 
	 */
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)	throws SlickException {
		g.translate(camera.getX(), camera.getY());
		dungeon.render(0,0);
		g.setFont(font);

		//Draw Player
		if(player.isWalking()){
			player.getAnimation().draw(player.getX(),player.getY(),50,50);
		}
		else{
			player.getImage().draw(player.getX(),player.getY(),50,50);
		}

		//Draw Enemies
		for(Enemy enemy: enemies){
			enemy.getAnimation().draw(enemy.getX(),enemy.getY(),50,50);
		}

		//Draw Health Bars
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

		//Draw Projectiles
		for(int i = 0; i < projectiles.size(); i++){
			Projectile temp = projectiles.get(i);
			for(int j =0;j<40;j++){
				temp.shoot();
				temp.getImage().draw((float)temp.getX(),(float)temp.getY());
			}
		}
		for(int i = 0; i < enemyProjectiles.size(); i++){
			Projectile temp = enemyProjectiles.get(i);
			for(int j =0;j<40;j++){
				temp.shoot();
				temp.getImage().draw((float)temp.getX(),(float)temp.getY());
			}
		}
		if(gameOver){
			g.drawString("YOU LOSE",player.getX(),player.getY()-100);

		}

	}

	@Override
	/**
	 * adjusts the game/ handles logic on a clock.
	 */
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
		
		Projectile.checkVisible(enemyProjectiles);
		Projectile.checkVisible(projectiles);
		//handle enemies
		for(int i = 0;i<enemies.size();i++){
			enemies.get(i).randomMovement();
			if(enemies.get(i).randomAttack()==1){
				enemyProjectiles.add(enemies.get(i).attack());
			}
		}

		//Check Player Input
		if(keyboard.isKeyPressed(Input.KEY_ESCAPE)){
			gc.exit();
		}
		if(keyboard.isKeyPressed(Input.KEY_SPACE)){
			projectiles.add(player.attack());
		}
		if(!player.getDead()){
			if(keyboard.isKeyPressed(Input.KEY_W)){
				player.setDirection("up");
				if(dungeon.getTileId(((int)player.getX()/50),((int)player.getY()/50)-1,wallLayer)==0){
					player.moveUp();
					camera.moveUp();
				}
			}
			else if(keyboard.isKeyPressed(Input.KEY_A)){
				player.setDirection("left");
				if(dungeon.getTileId(((int)player.getX()/50)-1,(int)player.getY()/50,wallLayer)==0){
					player.moveLeft();
					camera.moveLeft();
				}	
			}
			else if(keyboard.isKeyPressed(Input.KEY_S)){
				player.setDirection("down");
				if(dungeon.getTileId((int)player.getX()/50,((int)player.getY())/50+1,wallLayer)==0){
					player.moveDown();
					camera.moveDown();
				}		
			}
			else if(keyboard.isKeyPressed(Input.KEY_D)
					){
				player.setDirection("right");
				if(dungeon.getTileId(((int)player.getX()/50)+1,(int)player.getY()/50,wallLayer)==0){
					player.moveRight();
					camera.moveRight();
				}		
			}
		}
		else{
			player.die();
		}


		//Check Health
		if(!(dungeon.getTileId((int)player.getX()/50, (int)player.getY()/50, healthLayer)==0)){
			player.heal();
		}

		//Check projectiles hitting the enemies and player
		enemiesCopy = new ArrayList<Enemy>(enemies);
		for(Enemy enemy: enemiesCopy){
			for(Projectile proj: projectiles){
				if(proj.hitEnemy(enemy)){
					enemy.setHealth(10);
					if(enemy.getHealth()==0){
						enemies.remove(enemy);
					}
				}
			}
			for(Projectile proj : enemyProjectiles){
				if(proj.hitPlayer(player)){
					player.setHealth(2);
				}
			}

			if(player.getHealth()==0){
				gameOver = true;
				player.setDead(true);
			}

		}



	}

	@Override
	public int getID() {
		return 1;
	}


}
