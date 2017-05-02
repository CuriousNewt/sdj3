import java.util.ArrayList;


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
		
		Truck exporting = new Truck();
		ArrayList<Box> boxes = new ArrayList<>();
		boxes.add(box);
		boxes.add(box1);
		boxes.add(box2);
		boxes.add(new Box("fuck off1", "fuck off1"));
		boxes.add(new Box("fuck off2", "fuck off2"));
		boxes.add(new Box("fuck off3", "fuck off3"));
		boxes.add(new Box("fuck off4", "fuck off4"));
		boxes.add(new Box("fuck off5", "fuck off5"));
		boxes.add(new Box("fuck off6", "fuck off6"));
		boxes.add(new Box("fuck off7", "fuck off7"));
		ArrayList<Palette> palettes = new ArrayList<>();
		Palette pal = new Palette();
		Palette pal1 = new Palette();
		Palette pal2 = new Palette();
		
		pal.addBoxToPalette(new Box("hello","hello"));
		pal2.addBoxToPalette(new Box("hello6","hello6"));
		pal1.addBoxToPalette(new Box("hello3","hello3"));
		pal1.addBoxToPalette(new Box("hello4","hello4"));
		
		
		palettes.add(pal);
		palettes.add(pal1);
		palettes.add(pal2);
		
		
		Station aS = new ArrivalStation(incoming);
		Station dS = new DepartureStation(exporting, boxes, palettes);
		
		dS.loadCargo();
		dS.getTruck().print();
		
/*		
		aS.getAndUnloadCargo();
		aS.extractAllPalettes();
		aS.print();*/
	}
}
