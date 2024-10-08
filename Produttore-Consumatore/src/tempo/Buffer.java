package tempo;
import java.util.ArrayList;
 
public class Buffer {
	ArrayList<Valore> coda;
	int size;
	public Buffer() {
		this(Integer.MAX_VALUE);
	}
	public Buffer(int size) {
		this.size = size;
		coda = new ArrayList<Valore>();
	}
	public synchronized void add(int value, int priority) {
		Valore n = new Valore(value);
		while(true) {
			if(coda.size() < size) {
				coda.add(n);
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
				int value = coda.removeFirst().value;
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