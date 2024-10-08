package tempo;

public class Main {
 
	static int bufferSize = 5;
	static int goal = 50;
	
	public static void main(String[] args) {
		Buffer buffer = new Buffer(bufferSize);
		Thread prod = new Thread(new Produttore(buffer, goal));
		prod.setName("Prod");
		Thread cons = new Thread(new Consumatore(buffer, goal));
		cons.setName("Cons");
		prod.start();
		cons.start();
	}
}