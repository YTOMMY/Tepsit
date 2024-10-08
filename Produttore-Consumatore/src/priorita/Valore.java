package priorita;

public class Valore {
	public int value;
	public int priority;
	
	
	public Valore() {
		this(0, 0);
	}
	
	public Valore(int value, int priority) {
		this.value = value;
		this.priority = priority;
	}
}