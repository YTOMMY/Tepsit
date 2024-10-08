package best_effort;
import java.util.ArrayList;
 
public class Buffer {
	
	ArrayList<Integer> coda;
	int size;
	int persi;
	
	public Buffer(int size) {
		this.size = size;
		this.persi = 0;
		coda = new ArrayList<Integer>();
	}
	
	public int getPersi() {
		return persi;
	}
	
	public synchronized void add(int value) {
		if(coda.size() < size) {
			coda.add(value);
		} else {
			persi++;
		}
		this.notifyAll();
		return;
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