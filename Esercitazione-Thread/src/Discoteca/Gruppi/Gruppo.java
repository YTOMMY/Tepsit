package Discoteca.Gruppi;

import java.util.Random;

public class Gruppo implements Runnable {
	private Discoteca disco;
	private int n;
	boolean dentro;
	
	public Gruppo(int persone, Discoteca discoteca) {
		disco = discoteca;
		n = persone;
		dentro = false;
	}
	
	public void run() {
		Random rand = new Random();
		while(true) {
			try {
				Thread.sleep(Math.abs(rand.nextInt()) % 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(dentro) {
				disco.esci(n);
			} else {
				disco.entra(n);
			}
			dentro = !dentro;
		}
	}
}
