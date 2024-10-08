package multicast;

public class Valore {
	int value;
	int copies;
	
	public Valore(int value, int copies) {
		this.value = value;
		this.copies = copies;
	}
	
	public Integer GetValue() {
		if(copies > 0) {
			copies--;
			return value;
		}
		return null;
	}
	
	public boolean isEmpty() {
		return copies <= 0;
	}
}