package Discoteca.Stanze;

import java.util.Random;

public class Gruppo implements Runnable {
	private Discoteca disco;
	private int nPersone;
	private int nPiste;
	private int nuovaPista;
	private int pista;
	
	public Gruppo(int persone, Discoteca discoteca, int piste) {
		disco = discoteca;
		nPiste = piste;
		nPersone = persone;
		nuovaPista = -1;
	}
	
	public void run() {
		Random rand = new Random();
		while(true) {
			try {
				Thread.sleep(Math.abs(rand.nextInt()) % 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			pista = nuovaPista;
			nuovaPista = Math.abs(rand.nextInt()) % (nPiste + 1) - 1;
			if(pista != nuovaPista) {
				if(pista == -1) {
					disco.entra(nPersone, nuovaPista);
				}
				else if(nuovaPista == -1) {
					disco.esci(nPersone, pista);
				}
				else {
					disco.cambia(nPersone, pista, nuovaPista);
				}
			}
 		}
	}
}
