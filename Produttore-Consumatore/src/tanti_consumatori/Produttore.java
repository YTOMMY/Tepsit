package tanti_consumatori;
 
import java.util.Random;
 
public class Produttore implements Runnable{
	Buffer buffer;
	public Produttore(Buffer buffer) {
		this.buffer = buffer;
	}
	
	public void run() {
		Random rand = new Random();
		while(true) {
			int R = rand.nextInt(2048) - 1024;
			try {
				Thread.sleep(R >= 0 ? (R/100) * 50 : 200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			buffer.add(R);
		}
	}
}