package Teatro.Sale;

import java.util.Random;

public class Spettatore implements Runnable{
	private char id;
	private Sala sala;
	private Point posto;
	private boolean stop;
	
	public Spettatore(char id, Sala sala, Point posto) {
		this.id = id;
		this.sala = sala;
		this.posto = posto;
		this.stop = false;
	}
	
	public void stop() {
		stop = true;
	}
	
	public void run() {
		Random rand = new Random();
		while(!stop) {
			try {
				Thread.sleep(Math.abs(rand.nextInt() % 40));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if(!sala.prenotaPosto(id, posto)) {
				stop();
			}
		}
	}
}
