package Discoteca.Singolo;

import java.util.Random;

public class Persona implements Runnable {
	private Discoteca disco;
	boolean dentro;
	
	public Persona(Discoteca discoteca) {
		disco = discoteca;
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
				disco.esci();
			} else {
				disco.entra();
			}
			dentro = !dentro;
		}
	}
}
