package Discoteca.Singolo;

public class Discoteca {
	public int n;
	
	public Discoteca() {
		n = 0;
	}
	
	public synchronized void entra() {
		n++;
	}
	
	public synchronized void esci() {
		n--;
	}
	
	public synchronized int getN() {
		return n;
	}
}
