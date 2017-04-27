
public class Test {

	public static void main(String[] args) {
		
		DatabaseAdapter a = new DatabaseAdapter();
	
		Box box = new Box("GanjaChickenMeat","Chicken");
		Box box1 = new Box("GanjaCowMeat","Cow");
		
	/*	a.storeBox(box);
		a.storeBox(box);
		a.storeBox(box);
		a.storeBox(box1);
		*/
		
	
		a.viewAllBoxes("GanjaChickenMeat");
	}

}
