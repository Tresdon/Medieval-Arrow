
public class InstaHealth extends Item{

	public InstaHealth(String itemName, double x, double y) {
		super(itemName, x, y);
	}
	
	public boolean touching(Player aPlayer){
		if(this.getXCoor()+10 == aPlayer.getX() || this.getYCoor()+10 == aPlayer.getY()){
			return true;
		}
		else{
			return false;
		}
	}
	
	//Assuming the getter and setter names are as follows
	public void addHealth(Player aPlayer){
		if(aPlayer.getHealth()+50 <= aPlayer.getMaxHealth()){
			aPlayer.setHealth(aPlayer.getHealth()+50);
		}
	}
	
	
	public void pickup(Player aPlayer){
		if(touching(aPlayer)){
			addHealth(aPlayer);
		}
	}
	

}
