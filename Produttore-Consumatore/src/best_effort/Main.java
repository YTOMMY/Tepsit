package best_effort;

public class Main {
 
	static int bufferSize = 10;
	static int T = 5;
	
	public static void main(String[] args) {
		Buffer buffer = new Buffer(bufferSize);
		Thread prod = new Thread(new Produttore(buffer));
		prod.setName("prod-0");
		Thread[] cons = new Thread[T];
		for(int i = 0; i < T; i++) {
			cons[i] = new Thread(new Consumatore(buffer));
			cons[i].setName("cons-" + i);
		}
		prod.start();
		for(int i = 0; i < T; i++) {
			cons[i].start();
		}
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("--------------------------------\n" + 
								"Dati persi: " + buffer.getPersi() + "\n");
		}
	}
}