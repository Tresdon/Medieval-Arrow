
public class Camera {
	
	private int x;
	private int y;
	public Camera(int x, int y){
		this.x = -x;
		this.y = -y;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setY(int val){
		x = val;
	}
	public void setX(int val){
		y = val;
	}
	public void moveUp(){
		y+=50;
	}
	public void moveDown(){
		y-=50;
	}
	public void moveLeft(){
		x+=50;
	}
	public void moveRight(){
		x-=50;
	}
}
