package tempo;

import java.util.Random;
 
public class Produttore implements Runnable{
	Buffer buffer;
	int limit;
	int[] times;
	
	public Produttore(Buffer buffer, int limit) {
		this.buffer = buffer;
		this.limit = limit;
		times = new int[]{200, 400, 600, 800, 1000};
	}
	
	public void run() {
		Random rand = new Random();
		for(int i = 0; i < limit; i++) {
			try {
				Thread.sleep(times[rand.nextInt(5)]);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			buffer.add(rand.nextInt(1024), rand.nextInt(10));
		}
	}
}