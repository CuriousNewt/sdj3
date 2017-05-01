import java.util.ArrayList;


public abstract class Station {
	
	private IWorkerController worker;
	private ArrayList<Palette> palettes;
	private ArrayList<Box> boxes;
	
	public IWorkerController getWorker() {
		return worker;
	}

	public ArrayList<Palette> getPalettes() {
		return palettes;
	}

	public ArrayList<Box> getBoxes() {
		return boxes;
	}

	public Station(){
		this.worker = new WorkerController();
		this.palettes = new ArrayList<>();
		this.boxes = new ArrayList<>();
	}
	
	public abstract void sayHello();

}
