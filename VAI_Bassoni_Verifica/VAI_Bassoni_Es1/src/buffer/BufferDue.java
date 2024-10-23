/*
 * Nell'esempio dato non possono avvenire deadlock, mentre le race-condition possono avvenire solo se esistono più consumatori (o produttori) che volgiono accedere allo stesso momento
 * Nonostante questo è presente un errore nel programma, infatti se il produttore troverà il buffer pieno andrà in wait(), ma nel metodo remove non sono presenti notify(), in questo
 * modo il produttore rimarrà bloccato per sempre
 * 
 * per avere più consumatori bisogna modificare i notify() in notifyAll() 
 */

package buffer;
public class BufferDue{
	
	private static final int MAX_SIZE = 10;
	private int[] buf;
	private int inizio;
	private int fine;
	private int tot;
	
	public BufferDue() {
		buf = new int[MAX_SIZE];
		inizio = 0;
		fine = 0;
		tot = 0;
	}
	
	public void add(int v) {
		int pos = -1;
		synchronized (buf) {
			while(tot == buf.length) {
				try {
					buf.wait();
				} catch (InterruptedException e) {
				}
			}
			pos = fine;
			fine = (fine + 1) % buf.length;
			tot++;
		}
		buf[pos] = v;
		synchronized (buf) {
			buf.notifyAll();
		}
	}
	
	public int remove() {
		int pos = -1;
		synchronized (buf) {
			while(tot == 0) {
				try {
					buf.wait();
				} catch (InterruptedException e) {
				}
			}
			pos = inizio;
			inizio = (inizio + 1) % buf.length;
			tot--;
		}
		synchronized (buf) {
			buf.notifyAll();
		}
		return buf[pos];
	}
}