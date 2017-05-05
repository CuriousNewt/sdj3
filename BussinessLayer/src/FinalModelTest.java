import java.rmi.RemoteException;
import java.util.ArrayList;


public class FinalModelTest {
	
	static IConveyorQueue<Box> queue = new ConveyorQueue<>();

	public static void main(String[] args) {
		try {
			Box box = new Box("1","1");
			box.setArrivingBox(true);
			queue.enqueue(box);
			queue.enqueue(new Box("2","2"));
			queue.enqueue(new Box("3","3"));
			queue.enqueue(new Box("4","4"));
			queue.enqueue(new Box("5","5"));
			
			
			
			
			Crane crane = new Crane(queue);
			
			IWorkerController arrC = new WorkerController(queue, "Arrivals");
			IWorkerController depC = new WorkerController(queue, "Departures");
			
			Truck incoming = new Truck();
			
			Truck exporting = new Truck();
			ArrayList<Box> boxes = new ArrayList<>();
			ArrayList<Palette> palettes = new ArrayList<>();
			boxes.add(new Box("lol1", "lol1"));
			boxes.add(new Box("lol2", "lol2"));
			boxes.add(new Box("lol3", "lol3"));
			boxes.add(new Box("lol4", "lol4"));
			boxes.add(new Box("lol5", "lol5"));
			Palette pal = new Palette();
			Palette pal1 = new Palette();
			Palette pal2 = new Palette();
			
			pal.addBoxToPalette(new Box("hello","hello"));
			pal2.addBoxToPalette(new Box("hello6","hello6"));
			pal1.addBoxToPalette(new Box("hello3","hello3"));
			pal1.addBoxToPalette(new Box("hello4","hello4"));
			incoming.loadAPalette(pal1);
			incoming.loadAPalette(pal2);
			
			palettes.add(pal);
			palettes.add(pal1);
			palettes.add(pal2);
			
			Station arrS = new ArrivalStation(incoming, arrC);
			
			//arrS.checkBoolean();
			Station depS = new DepartureStation(exporting, boxes, palettes, queue, depC);
			
			
			Thread arrSThread = new Thread(arrS,arrC.getTag());
			Thread depSThread = new Thread(depS,depC.getTag());
			
			//exporting.print();

			arrSThread.start();
			depSThread.start();
			
			
			
			//crane.sendOrderToWarehouse(new Box("first","first"));
			
			/*Box wantedBox = crane.requestOrderFromWarehouse(new Box("Sausages", "Meat"));
			System.out.println(wantedBox);*/
			
			
			
		
		
		
		
		
		
		
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
