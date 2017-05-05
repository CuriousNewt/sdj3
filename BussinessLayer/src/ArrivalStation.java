import java.util.ArrayList;

public class ArrivalStation extends Station {

	private Truck truck;
	private ArrayList<Box> boxes;
	private ArrayList<Palette> palettes;
	private IWorkerController worker;

	public ArrivalStation(Truck truck, IWorkerController worker) {
		super();
		this.truck = truck;
		this.boxes = new ArrayList<>();
		this.palettes = new ArrayList<>();
		this.worker = worker;
		this.getAndUnloadCargo();
	}

	@Override
	public void getAndUnloadCargo() {

		Palette[] unloaded = this.truck.unloadPalettes();
		// System.out.println("UNLOADED ARRAY SIZE: " + unloaded.length);

		/*
		 * for (int i = 0; i < unloaded.length; i++) {
		 * System.out.println("Unloaded contents  " + unloaded[i]); }
		 */

		int count = 0;
		for (int i = 0; i < unloaded.length; i++) {
			for (int j = 0; j < unloaded[i].getBoxes().length; j++) {
				if (unloaded[i].getBox(j) != null) {
					// System.out.println("THESE ARE THE BOXES: " +
					// unloaded[i].getBox(j));
					count++;
				}
			}

		}
		// System.out.println("There are: " + count);

		for (int i = 0; i < count; i++) {
			for (int j = 0; j < count - 1; j++) {
				if (unloaded[i] != null) {
					if (unloaded[i].getBox(j) != null) {
						unloaded[i].getBox(j).setArrivingBox(true);
						palettes.add(unloaded[i]);
					}
				}
			}
		}

	}

	@Override
	public void extractAllPalettes() {

		for (int i = 0; i < palettes.size(); i++) {
			for (int j = 0; j < palettes.get(i).getBoxes().length; j++) {
				if (palettes.get(i).getBox(j) != null) {
					this.boxes.add(palettes.get(i).getBox(j));
				}
			}
		}

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
	public void print() {

		for (int i = 0; i < this.boxes.size(); i++) {
			System.out.println(this.boxes.get(i));

		}

	}

	@Override
	public void loadCargo() {
		// nothing here

	}

	@Override
	public void run() {

		for (int i = 0; i < this.palettes.size(); i++) {
			for (int j = 0; j < this.palettes.get(i).getBoxes().length; j++) {
				if (this.palettes.get(i).getBox(j) != null) {
					this.palettes.get(i).getBox(j).setArrivingBox(true);

					this.worker.putOnBelt(this.palettes.get(i).getBox(j));
				}
				try {
					Thread.sleep(2500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	@Override
	public void checkBoolean() {

		for (int i = 0; i < palettes.size(); i++) {
			for (int j = 0; j < palettes.get(i).getBoxes().length; j++) {
				if (palettes.get(i).getBox(j) != null) {
					System.out.println(palettes.get(i).getBox(j).toString()
							+ palettes.get(i).getBox(j).arrivingBox);
				}
			}
		}

	}

}
