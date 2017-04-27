
public class Palette {
	private Box[] boxes;
	private final int maxNumberOfBoxes = 10;
	private int index;

	public Palette() {
		boxes = new Box[maxNumberOfBoxes];
		index = 0;
	}

	public void addBoxToPalette(Box box) {
		this.boxes[index] = box;
		index++;
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
}
