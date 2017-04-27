
public class Box {
	private String itemName;
	private String itemType;
	
	public Box(String itemName, String itemType){
		this.itemName = itemName;
		this.itemType = itemType;
	}
	
	public String getName(){
		return itemName;
	}
	//as
	public String getType(){
		return itemType;
	}
}