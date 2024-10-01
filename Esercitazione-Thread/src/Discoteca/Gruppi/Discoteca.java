package Discoteca.Gruppi;

public class Discoteca {
	public int n;
	
	public Discoteca() {
		n = 0;
	}
	
	public synchronized void entra(int persone) {
		n += persone;
	}
	
	public synchronized void esci(int persone) {
		n -= persone;
	}
	
	public synchronized int getN() {
		return n;
	}
}
