package Discoteca.Stanze;

public class Discoteca {
	public int[] piste;
	
	public Discoteca(int nPiste) {
		piste = new int[nPiste];
		for(int i = 0; i < nPiste; i++) {
			piste[i] = 0;
		}
	}
	
	public synchronized void entra(int persone, int pista) {
		piste[pista] += persone;
	}
	
	public synchronized void esci(int persone, int pista) {
		piste[pista] -= persone;
	}
	
	public synchronized void cambia(int persone, int pistaOrigine, int pistaDestinazione) {
		piste[pistaOrigine] -= persone;
		piste[pistaDestinazione] += persone;
	}
	
	public synchronized int getPista(int pista) {
		return piste[pista];
	}
}
