import java.util.ArrayList;

public class ArrivalStation extends Station {

	private Truck truck;
	private ArrayList<Box> boxes;
	private ArrayList<Palette> palettes;

	public ArrivalStation(Truck truck) {
		super();
		this.truck = truck;
		this.boxes = new ArrayList<>();
		this.palettes = new ArrayList<>();
	}

	@Override
	public void getAndUnloadCargo() {

		Palette[] unloaded = this.truck.unloadPalettes();

		for (int i = 0; i < unloaded.length; i++) {
			if (unloaded[i] != null) {
				palettes.add(unloaded[i]);
			}
		}
	
	}

	@Override
	public void extractAllPalettes() {
		
		for (int i = 0; i < palettes.size(); i++) {
			for (int j = 0; j < palettes.get(i).getBoxes().length; j++) {
				if(palettes.get(i).getBox(j) != null){
					this.boxes.add(palettes.get(i).getBox(j));
				}
			}
		}
		
	}

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
		//nothing here
		
	}

}
