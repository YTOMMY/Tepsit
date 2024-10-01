package Teatro.Main;

import Teatro.Sale.*;

public class Main {

	static int T = 7;
	static int file = 15;
	static int postiFila = 46;
	static int secSpettacolo = 2;
	
	public static void main(String[] args) {
		Thread[] threads = new Thread[T];
		Sala sala = new Sala(file, postiFila);
		for(int i = 0 ; i < T; i++) {
			threads[i] = new Thread(new Spettatore((char)(i + '1'), sala, new Point(0, 0)));
		}
		for(int i = 0; i < T; i++) {
			threads[i].start();
		}
		//for(int i = 0; i < secSpettacolo; i++) {
			try {
				Thread.sleep(secSpettacolo * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		//}
		sala.inizioSpettacolo();
		printSala(sala.getPosti());
		for(int i = 0; i < T; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void printSala(char[][] sala) {
		for(int i = 0; i < sala.length; i++) {
			for(int j = 0; j < sala[0].length; j++) {
				System.out.print(sala[i][j] + " ");
			}
			 System.out.println("\n--------------------------------------------------------------------------------------------");
		}
	}
}
