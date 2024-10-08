package Lifo.Main;
 
import Lifo.Threads.*;
 
public class Main {
 
	static int bufferSize = 10;
	
	public static void main(String[] args) {
		Buffer buffer = new Buffer(bufferSize);
		Thread prod = new Thread(new Produttore(buffer));
		prod.setName("Produttore");
		Thread cons = new Thread(new Consumatore(buffer));
		cons.setName("Consumatore");
		prod.start();
		cons.start();
	}
}