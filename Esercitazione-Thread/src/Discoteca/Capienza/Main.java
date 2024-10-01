package Discoteca.Capienza;

import java.util.Random;

public class Main {

	static int T = 100;
	static int tempo = 1000;
	static int personeMax = 10;
	static int capienza = 161;
	
	public static void main(String[] args) {
		Gruppo[] threads = new Gruppo[T];
		Discoteca disco = new Discoteca(capienza);
		Random rand = new Random();
		for(int i = 0 ; i < T; i++) {
			threads[i] = new Gruppo(Math.abs(rand.nextInt()) % personeMax, disco);
		}
		for(int i = 0; i < T; i++) {
			threads[i].start();
		}
		while(true) {
			try {
				Thread.sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Persone nella discoteca: " + disco.getN());
		}
	}
}
