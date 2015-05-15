import java.awt.Color;
import java.awt.Graphics;


public class Dungeon {
	private int width, height, blockSize;
	private String[][] blocks;
	
	public Dungeon(int w, int h, int s){
		width = w;
		height = h;
		blockSize = s;
	}
	
	public Dungeon(){
		width = 600;
		height = 600;
		blockSize = 100;
		create();
	}
	
	public void create(){
		blocks = new String[][]{
			{"0","0","0","0","0","0",},
			{"0","0","1","1","1","0",},
			{"0","0","1","1","1","1",},
			{"0","0","1","1","1","1",},
			{"0","0","0","0","0","0",},
			{"0","0","0","0","0","0",},
		};	
	}
	public void draw(Graphics g){
		for(int i =0;i<blocks.length;i++){
			for(int j =0; j<blocks[i].length; j++){
				if (blocks[i][j].equals("0")) {
					g.setColor(Color.black);
					g.fillRect(j*blockSize, i*blockSize, blockSize, blockSize);
				}
				else if(blocks[i][j].equals("1")){
//					g.setColor(Color.white);
//					g.fillRect(j*blockSize, i*blockSize, blockSize, blockSize);
				}
				
			}
		}
	}
	
}
