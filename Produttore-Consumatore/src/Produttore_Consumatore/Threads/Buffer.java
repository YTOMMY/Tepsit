package Produttore_Consumatore.Threads;
import java.util.LinkedList;
import java.util.Queue;
 
public class Buffer {
	
	Queue<Integer> coda;
	int size;
	public Buffer() {
		this(Integer.MAX_VALUE);
	}
	
	public Buffer(int size) {
		this.size = size;
		coda = new LinkedList<>();
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
			if(coda.peek() != null) {
				int value = coda.remove();
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