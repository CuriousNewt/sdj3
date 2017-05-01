import java.io.Serializable;


public class Box implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String itemName;
	private String itemType;
	
	public Box(String n, String t){
		this.itemName = n;
		this.itemType = t;
	}
	
	public String getItemName() {
		return itemName;
	}
	//kkt9
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public String getItemType() {
		return itemType;
	}
	//skurvenyleonajqwdqwjkghbhnnjqwdwanyadgKURVAFIXKURVAlolwqfq
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	
	public String toString(){
		
		return "Item name: " + itemName + "\nItem type: " + itemType;
	}

}
