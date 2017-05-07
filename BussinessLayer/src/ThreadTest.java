import java.util.ArrayList;

import src.Box;


public class ThreadTest {

	public static void main(String[] args) {
		
		IConveyorQueue<Box> queue = new ConveyorQueue<>();
		queue.enqueue(new Box("FirstTempBox","FirstTempBox"));
		queue.enqueue(new Box("SecondTempBox","SecondTempBox"));
		IWorkerController arrC = new WorkerController(queue, "Arrivals");
		IWorkerController depC = new WorkerController(queue, "Departures");
		Truck incoming = new Truck();
		Truck exporting = new Truck();
		ArrayList<Box> boxes = new ArrayList<>();
		ArrayList<Palette> palettes = new ArrayList<>();
		boxes.add(new Box("fuck off1", "fuck off1"));
		boxes.add(new Box("fuck off2", "fuck off2"));
		boxes.add(new Box("fuck off3", "fuck off3"));
		boxes.add(new Box("fuck off4", "fuck off4"));
		boxes.add(new Box("fuck off5", "fuck off5"));
		Palette pal = new Palette();
		Palette pal1 = new Palette();
		Palette pal2 = new Palette();
		
		pal.addBoxToPalette(new Box("hello","hello"));
		pal2.addBoxToPalette(new Box("hello6","hello6"));
		pal1.addBoxToPalette(new Box("hello3","hello3"));
		pal1.addBoxToPalette(new Box("hello4","hello4"));
		incoming.loadAPalette(pal1);
		
		palettes.add(pal);
		palettes.add(pal1);
		palettes.add(pal2);
		
		Station aS = new ArrivalStation(incoming,arrC);
		aS.getAndUnloadCargo();
		Station dS = new DepartureStation(exporting, boxes, palettes,queue,depC);
		 
		Thread t1 = new Thread(aS,arrC.getTag());
		Thread t2 = new Thread(dS,depC.getTag());

		
		t1.start();
		t2.start();
	}

}
