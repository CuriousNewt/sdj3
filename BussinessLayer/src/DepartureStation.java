import java.util.ArrayList;

public class DepartureStation extends Station {

	private Truck truck;
	private ArrayList<Box> boxes;
	private ArrayList<Palette> palettes;
	private IConveyorQueue<Box> queue;
	private IWorkerController worker;

	public DepartureStation(Truck truck, ArrayList<Box> boxes,
			ArrayList<Palette> palettes, IConveyorQueue<Box> queue, IWorkerController worker) {
		super();
		this.truck = truck;
		this.boxes = boxes;
		this.palettes = palettes;
		this.queue = queue;
		this.worker = worker;
	}

	@Override
	public Truck getTruck() {
		return truck;
	}

	public ArrayList<Box> getBoxes() {
		return boxes;
	}

	public ArrayList<Palette> getPalettes() {
		return palettes;
	}

	@Override
	public void getAndUnloadCargo() {

		// nothing here
	}

	@Override
	public void extractAllPalettes() {

	}

	@Override
	public void print() {

	}

	@Override
	public void loadCargo() {

		if (!checkTruckSpace()) {
			return;
		}
		// 1st case check all nonfull palettes, fill them with boxes until they
		// are full at the station and load them to the truck
		for (int i = 0; i < palettes.size(); i++) {
			for (int j = 0; j < boxes.size(); j++) {
				if (!palettes.get(i).isFull()) {
					if (isEnoughBoxes()) {
						palettes.get(i).transfer(boxes.get(j));
						this.boxes.remove(j); //could be problematic
					}
				}
			}
		}
		// 2nd case load all full palettes to the truck
		for (int i = 0; i < palettes.size(); i++) {
			System.out.println("Been here " + i);
			if (this.palettes.get(i).isFull()) {
				this.truck.loadAPalette(this.palettes.get(i));
				/*this.palettes.remove(i);*/
			}
		}
		
		this.palettes.clear();
	}

	private boolean isEnoughBoxes() {

		return this.boxes.size() != 0;
	}

	private boolean checkTruckSpace() {

		return this.truck.getActualCount() < this.truck.getCountOfPalettes();
	}

	@Override
	public void run() {
		
		while(true){
			
			if(this.truck.isFull()){
				System.out.println("Truck is leaving....");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				this.truck = new Truck();
			}
			
			if(!this.queue.first().arrivingBox){
				Box box = this.worker.takeFromBelt();
				//this.boxes.add(box);
				this.truck.loadABox(box);
				
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
	}

}
