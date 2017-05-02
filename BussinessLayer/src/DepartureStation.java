import java.util.ArrayList;

public class DepartureStation extends Station {

	private Truck truck;
	private ArrayList<Box> boxes;
	private ArrayList<Palette> palettes;

	public DepartureStation(Truck truck, ArrayList<Box> boxes,
			ArrayList<Palette> palettes) {
		super();
		this.truck = truck;
		this.boxes = boxes;
		this.palettes = palettes;

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

		//int index = 0;

		/*
		 * for (int i = 0; i < palettes.size(); i++) { for (int j = 0; j <
		 * truck.getPalletes().length; j++) { if(palettes.get(i) != null){
		 * if(checkTruckSpace()){ if(isPalletFull(truck.getPalette(index))){
		 * index++; } if(!isPalletFull(truck.getPalette(index))){
		 * this.truck.loadAPalette(palettes.get(j)); this.palettes.remove(i); }
		 * } } } }
		 */

		/*for (int i = 0; i < palettes.size(); i++) {
			for (int j = 0; j < truck.getPalletes().length; j++) {
				while (!truck.getPalette(j).isFull()) {
					if (palettes.get(i) != null) {
						if (checkTruckSpace()) {
							this.truck.getPalette(j)
									.transferBox(makeAPalette());
						}
					}
				}
				if (checkTruckSpace()) {
					if (truck.getPalette(j).isFull()) {
						this.truck.loadAPalette(palettes.get(j));
						this.palettes.remove(i);
					}
				}
			}
		}*/

		
		

		// 1st case check all nonfull palettes, fill them with boxes until they
		// are full at the station and load them to the truck
		for (int i = 0; i < palettes.size(); i++) {
			for (int j = 0; j < boxes.size(); j++) {
				if (!palettes.get(i).isFull()) {
					if (isEnoughBoxes()) {
						palettes.get(i).transfer(boxes.get(j));
						this.boxes.remove(j);
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

		/*
		 * if (checkTruckSpace()) { this.truck.loadAPalette(makeAPalette()); }
		 */
	}

	private boolean isEnoughBoxes() {

		return this.boxes.size() != 0;
	}

	private boolean checkTruckSpace() {

		return this.truck.getActualCount() < this.truck.getCountOfPalettes();
	}

	private Palette makeAPalette() {

		Palette p = new Palette();

		for (int i = 0; i < boxes.size(); i++) {
			if (boxes.get(i) != null) {
				p.addBoxToPalette(boxes.get(i));
				boxes.remove(i);
			}
		}

		return p;
	}

}
