package Main;

import Magazzino.*;
import java.util.Random;
import java.util.ArrayList;

public class Main {

	static int N = 50;
	static int C = 2;
	static int S = 100;
	static int A = 5;
	static String[] ZONE = new String[]{"elettronica", "idraulica", "ferramenta"};
	
	
	public static void main(String[] args) {
		Random rand = new Random();
		Zona[] zone = new Zona[ZONE.length];
		Container[] cont = new Container[C];
		Thread[] addetti = new Thread[A];
		
		for(int i = 0; i < ZONE.length; i++) {
			zone[i] = new Zona(ZONE[i], S);
		}
		
		for(int i = 0; i < C; i++) {
			ArrayList<Collo> colli = new ArrayList<Collo>();
			for(int j = 0; j < N; j++) {
				colli.add(new Collo(j, ZONE[rand.nextInt(ZONE.length)]));
			}
			cont[i] = new Container(colli); 
		}
		
		for(int i = 0; i < A; i++) {
			String zona = ZONE[rand.nextInt(ZONE.length)];
			addetti[i] = new Thread(new Addetto(zona, cont, zone));
			addetti[i].setName(zona + " (" + i + ")");
		}
		
		for(int i = 0; i < A; i++) {
			addetti[i].start();
		}
	}

}
