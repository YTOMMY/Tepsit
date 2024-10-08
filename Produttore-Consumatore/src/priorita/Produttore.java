package priorita;

import java.util.Random;
 
public class Produttore implements Runnable{
	Buffer buffer;
	public Produttore(Buffer buffer) {
		this.buffer = buffer;
	}
	
	public void run() {
		Random rand = new Random();
		while(true) {
			try {
				Thread.sleep(rand.nextInt(901) + 100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			buffer.add(rand.nextInt(1024), rand.nextInt(10));
		}
	}
}