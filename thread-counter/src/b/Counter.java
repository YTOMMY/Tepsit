package b;

public class Counter implements Runnable{
	int n;
	int d;
	boolean rev;
	
	public Counter(int max,  int time, boolean reverse) {
		n = max;
		d = time;
		rev = reverse;
	}
	
	public void run() {
		String threadInfo = Thread.currentThread().getName() + " (" + Thread.currentThread().threadId() + "): ";
		
		System.out.println(threadInfo + "START");
		if(!rev) {
			for (int i = 0; i <= n; i++) {
				System.out.println(threadInfo + i);
				try {
					Thread.sleep(d);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} else {
			for (int i = n; i > 0; i--) {
				System.out.println(threadInfo + i);
				try {
					Thread.sleep(d);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(threadInfo + "END");
	}
	
	public void aspetta(int time){
			
	}
}
