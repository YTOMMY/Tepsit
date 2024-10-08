package priorita;

public class Main {
 
	static int bufferSize = 10;
	
	public static void main(String[] args) {
		Buffer buffer = new Buffer(bufferSize);
		Thread prod = new Thread(new Produttore(buffer));
		prod.setName("Prod");
		Thread cons = new Thread(new Consumatore(buffer));
		cons.setName("Cons");
		prod.start();
		cons.start();
	}
}