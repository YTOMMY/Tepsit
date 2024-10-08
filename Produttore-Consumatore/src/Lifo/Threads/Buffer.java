package Lifo.Threads;
import java.util.Stack;
 
public class Buffer {
	
	Stack<Integer> stack;
	int size;
	public Buffer() {
		this(Integer.MAX_VALUE);
	}
	
	public Buffer(int size) {
		this.size = size;
		stack = new Stack<Integer>();
	}
	
	public synchronized void add(int value) {
		while(true) {
			if(stack.size() < size) {
				stack.push(value);
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
			if(!stack.empty()) {
				int value = stack.pop();
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