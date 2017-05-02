
public class Test {

	
	public static void main(String[] args) {
		
		Truck incoming = new Truck();
		Box box = new Box("s","l");
		Box box1 = new Box("s1","l1");
		Box box2 = new Box("s2","l2");
		Palette p = new Palette();
		p.addBoxToPalette(box);
		p.addBoxToPalette(box1);
		p.addBoxToPalette(box2);
		
		incoming.loadAPalette(p);
		
		Station aS = new ArrivalStation(incoming);
		
		
		aS.getAndUnloadCargo();
		aS.extractAllPalettes();
		aS.print();
	}
}
