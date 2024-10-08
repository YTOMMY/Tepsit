package priorita;
 
public class Consumatore implements Runnable{
	Buffer buffer;
		
	public Consumatore(Buffer buffer) {
		this.buffer = buffer;
	}
	
	public void run() {
		float pari = 0;
		for(float i = 1; true; i++) {
			int value = buffer.remove();
			if(value % 2 == 0) pari++;
			System.out.println("--------------------------------");
			System.out.println(Thread.currentThread().getName() + ": ");
			System.out.println("Numero: " + value);
			System.out.println("Pari: " + (pari / i) * 100 + "%");
		}
	}
}