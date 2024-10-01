package Discoteca.Stanze;

import java.util.Random;

public class Main {

	static int T = 100;
	static int tempo = 500;
	static int personeMax = 10;
	static int piste = 4;
	
	public static void main(String[] args) {
		Thread[] threads = new Thread[T];
		Discoteca disco = new Discoteca(piste);
		Random rand = new Random();
		for(int i = 0 ; i < T; i++) {
			threads[i] = new Thread(new Gruppo(Math.abs(rand.nextInt()) % personeMax, disco, piste));
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
			for(int i = 0; i < piste; i++) {
				System.out.println("Persone nella pista " + i + ": " + disco.getPista(i));
			}
			System.out.println();
		}
	}
}
