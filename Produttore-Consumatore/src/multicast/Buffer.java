package multicast;
import java.util.ArrayList;
 
public class Buffer {
	
	ArrayList<Valore> coda;
	int size;
	int threadNum;
	
	public Buffer(int size, int threadNum) {
		this.size = size;
		this.threadNum = threadNum;
		coda = new ArrayList<Valore>();
	}
	
	public synchronized void add(int value) {
		while(true) {
			if(coda.size() < size) {
				coda.add(new Valore(value, threadNum));
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
				Valore valore = coda.getFirst();
				int num = valore.GetValue();
				if(valore.isEmpty()) {
					coda.removeFirst();
				}
				this.notifyAll();
				return num;
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