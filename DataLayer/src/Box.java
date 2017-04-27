
public class Box {
	
	private String itemName;
	private String itemType;
	
	public Box(String n, String t){
		this.itemName = n;
		this.itemType = t;
	}
	
	public String getItemName() {
		return itemName;
	}
	//kkt
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getItemType() {
		return itemType;
	}
	//skurvenyleona
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

}
