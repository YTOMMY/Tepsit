package tempo;

import java.util.Random;

public class Consumatore implements Runnable{
	Buffer buffer;
	int limit;
	int[] times;
		
	public Consumatore(Buffer buffer, int limit) {
		this.buffer = buffer;
		this.limit = limit;
		times = new int[]{200, 400, 600, 800, 1000};
	}
	
	public void run() {
		float pari = 0;
		Random rand = new Random();
		for(float i = 0; i < limit + 1; i++) {
			try {
				Thread.sleep(times[rand.nextInt(5)]);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			int value = buffer.remove();
			if(value % 2 == 0) pari++;
			System.out.println("--------------------------------");
			System.out.println(Thread.currentThread().getName() + "(" + (int)i + "): ");
			System.out.println("Numero: " + value);
			System.out.println("Pari: " + (pari / (i+1)) * 100 + "%");
		}
	}
}