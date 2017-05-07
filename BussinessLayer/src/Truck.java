import src.Box;

public class Truck {

	private Palette[] palettes;
	private int index;

	public Truck() {
		this.palettes = new Palette[3];
		for (int i = 0; i < palettes.length; i++) {
			this.palettes[i] = new Palette();
		}
		this.index = 0;
	}

	public void loadABox(Box box) {
		for (int i = 0; i < index; i++) {
			if (!palettes[i].isFull()) {
				palettes[i].addBoxToPalette(box);
			}
		}
	}

	public void loadAPalette(Palette p) {
		if (this.index < this.palettes.length) {
			this.palettes[index] = p;
			this.index++;
		}
	}

	public Palette[] unloadPalettes() {
		Palette[] unloaded = copy(this.palettes);
		clear(this.palettes);
		return unloaded;
	}

	private Palette[] copy(Palette[] p) {
		
	/*	int count = 0;
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < p[i].getBoxes().length; j++) {
				if(p[i].getBox(j) != null){
					count++;
				}
			}
		}*/
		
	
		Palette[] toReturn = new Palette[p.length];
		for (int i = 0; i < p.length; i++) {
			if (p[i] != null) {
				toReturn[i] = p[i];
			}
		}
		return toReturn;
	}

	private void clear(Palette[] p) {
		for (int i = 0; i < p.length; i++) {
			p[i] = null;
		}
	}

	public int getCountOfPalettes() {
		return this.palettes.length;
	}

	public Palette[] getPalletes() {
		return this.palettes;
	}

	public Palette getPalette(int index) {
		return this.palettes[index];
	}

	public int getActualCount() {
		return index;
	}

	public void print() { // test method
		for (int i = 0; i < palettes.length; i++) {
			System.out.println(i + " " + palettes[i]);
		}
	}

	public boolean isFull() {
		for (int i = 0; i < palettes.length; i++) {
			if (!palettes[i].isFull()) {
				return false;
			}
		}

		return true;
	}

}
