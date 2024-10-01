package Discoteca.Capienza;

import java.util.ArrayList;

public class Discoteca implements Runnable{
	public int n;
	public int cap;
	public ArrayList<Thread> waitingList;
	
	public Discoteca(int capienza) {
		n = 0;
		cap = capienza;
		waitingList = new ArrayList<Thread>();
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
	
	public void run() {
		while(true) {
			if(waitingList.size() > 0) {
				Thread t;
				synchronized(this) {
					t = waitingList.get(0);
					if(n + )
				}
			}
		}
	}
}
