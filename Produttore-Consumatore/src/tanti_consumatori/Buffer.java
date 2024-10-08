package tanti_consumatori;
import java.util.ArrayList;
 
public class Buffer {
	
	ArrayList<Integer> coda;
	int size;
	public Buffer() {
		this(Integer.MAX_VALUE);
	}
	
	public Buffer(int size) {
		this.size = size;
		coda = new ArrayList<Integer>();
	}
	
	public synchronized void add(int value) {
		while(true) {
			if(coda.size() < size) {
				coda.add(value);
				this.notifyAll();
				return;
			} else {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public synchronized int remove() {
		while(true) {
			if(coda.size() != 0) {
				int value = coda.removeFirst();
				this.notifyAll();
				return value;
			} else {
				try {
					this.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}