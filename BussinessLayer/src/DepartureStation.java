import java.util.ArrayList;


public class DepartureStation extends Station{
		
	private Truck truck;
	private ArrayList<Box> boxes;
	private ArrayList<Palette> palettes;
	
	public DepartureStation(Truck truck) {
		super();
		this.truck = truck;
		this.boxes = new ArrayList<>();
		this.palettes = new ArrayList<>();
	
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
	public void getAndUnloadCargo() {
		
		//nothing here
	}

	@Override
	public void extractAllPalettes() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loadCargo() {
		// TODO Auto-generated method stub
		
	}
	
	
	


}
