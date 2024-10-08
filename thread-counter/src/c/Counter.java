package c;

public class Counter implements Runnable{
	int n;
	
	public Counter(int n) {
		this.n = n;
	}
	
	public void run() {
		long tid = Thread.currentThread().threadId();
		String threadInfo = Thread.currentThread().getName() + " (" + tid + "): ";
		
		System.out.println(threadInfo + "START");
		for (long i = tid; i <= n; i += tid) {
			System.out.println(threadInfo + i);
		}
		System.out.println(threadInfo + "END");
	}
}
