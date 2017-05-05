import java.io.Serializable;


public class Box implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String itemName;
	private String itemType;
	public boolean arrivingBox;
	
	public Box(String n, String t){
		this.itemName = n;
		this.itemType = t;
		this.arrivingBox = false;
	}
	
	public synchronized boolean isArrivingBox() {
		return arrivingBox;
	}

	public void setArrivingBox(boolean arrivingBox) {
		this.arrivingBox = arrivingBox;
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
