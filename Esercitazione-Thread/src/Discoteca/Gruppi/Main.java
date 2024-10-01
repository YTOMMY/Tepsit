package Discoteca.Gruppi;

import java.util.Random;

public class Main {

	static int T = 100;
	static int tempo = 2000;
	static int personeMax = 10;
	
	public static void main(String[] args) {
		Thread[] threads = new Thread[T];
		Discoteca disco = new Discoteca();
		Random rand = new Random();
		for(int i = 0 ; i < T; i++) {
			threads[i] = new Thread(new Gruppo(Math.abs(rand.nextInt()) % personeMax, disco));
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
