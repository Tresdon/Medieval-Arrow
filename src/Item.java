
public class Item {
	private String name;
	private double xCoor;
	private double yCoor;
	public Item[] inventory = new Item[1];
	
	public Item(String itemName, double x, double y){
		name= itemName;
		xCoor=x;
		yCoor=y;
	}
	
	public String getName(){
		return name;
	}
	
	public double getXCoor(){
		return xCoor;
	}
	
	public double getYCoor(){
		return yCoor;
	}

}
