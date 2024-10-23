package Pizzeria;

public class Pizza {
	int spicchi;
	
	public Pizza(int spicchi) {
		this.spicchi = spicchi;
	}
	
	public void Mangia() {
		if(spicchi > 0) {
			spicchi--;
		}
	}
}
