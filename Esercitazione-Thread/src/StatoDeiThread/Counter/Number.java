package StatoDeiThread.Counter;

public class Number{
	
	int value;
	
	public Number() {
		this(0);
	}
	public Number(int value) {
		this.value = value;
	}
	
	public synchronized void Incrementa() {
		value++;
	}
	public synchronized int Get() {
		return value;
	}
}
