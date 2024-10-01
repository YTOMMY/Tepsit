package Discoteca.Singolo;

public class Main {

	static int T = 100;
	static int tempo = 1000;
	
	public static void main(String[] args) {
		Thread[] threads = new Thread[T];
		Discoteca disco = new Discoteca();
		for(int i = 0 ; i < T; i++) {
			threads[i] = new Thread(new Persona(disco));
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
