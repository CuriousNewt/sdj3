import src.Box;

public class Palette {
	private Box[] boxes;
	private final int maxNumberOfBoxes = 2;
	private int index;

	public Palette() {
		boxes = new Box[maxNumberOfBoxes];
		index = 0;
	}

	public void addBoxToPalette(Box box) {
		if (index < maxNumberOfBoxes) {
			this.boxes[index] = box;
			index++;
		}
	}

	public Box[] getBoxes() {
		return boxes;
	}

	public int getMaxNumberOfBoxes() {
		return maxNumberOfBoxes;
	}

	public void addMoreBoxes(Box[] boxes) {
		for (int i = 0; i < boxes.length; i++) {
			addBoxToPalette(boxes[i]);
		}
	}

	public Box removeBox() {
		index--;
		Box returned = this.boxes[index];
		this.boxes[index] = null;
		return returned;
	}

	// delete if not needed
	public Box getBox(int index) {
		return boxes[index];
	}

	public String toString() {
		String s = "This is a palette: \n";

		for (int i = 0; i < boxes.length; i++) {
			s += boxes[i] + "\n";
		}

		return s;
	}

	public int getCount() {
		return index;
	}

	public boolean isFull() {
		return this.index >= this.boxes.length;
	}

	/*public void transferBox(Palette p) {
		int tempIndex = 0;
		if (!isFull()) {
			for (int i = index; i < this.boxes.length; i++) {
				this.boxes[i] = p.getBox(tempIndex);
				index++;
				tempIndex++;
			}
		}
	}
*/
	public void transfer(Box box){
		
		if(!isFull()){
			for(int i = index; i < this.boxes.length; i++){
				this.boxes[i] = box;
				index++;
			}
		}
	}
}
