
public class Truck {
	
	private Palette[] palettes;
	private int index;
	
	
	public Truck(){
	   this.palettes = new Palette[15];
	   this.index = 0;
	}
	
	
	public void loadAPalette(Palette p){
		if(this.index < this.palettes.length){
			this.palettes[index] = p;
			this.index++;
		}
	}
	
	public Palette[] unloadPalettes(){
		Palette[] unloaded = copy(this.palettes);
		clear(this.palettes);
		return unloaded;
	}
	
	private Palette[] copy(Palette[] p){
		Palette[] toReturn = new Palette[p.length];
 		for (int i = 0; i < p.length; i++) {
			toReturn[i] = p[i];
		}
		return toReturn;
	}
	
	private void clear(Palette[] p){
		for (int i = 0; i < p.length; i++) {
			p[i] = null;
		}
	}
	
	public int getCountOfPalettes(){
		return this.palettes.length;
	}

}
