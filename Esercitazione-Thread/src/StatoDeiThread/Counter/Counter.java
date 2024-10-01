package StatoDeiThread.Counter;

public class Counter implements Runnable{
	
	int X, time;
	Number i;
	
	public Counter(Number num, int X, int time) {
		
		this.X = X;
		this.time = time;
		this.i = num;
	}
	
	public Number valueReference() {
		return i;
	}
	
	public void run() {
		for(; i.Get() < X; i.Incrementa()) {
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
