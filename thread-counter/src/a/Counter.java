package a;

public class Counter implements Runnable{
	int n;
	
	public Counter(int n) {
		this.n = n;
	}
	
	public void run() {
		String threadInfo = Thread.currentThread().getName() + " (" + Thread.currentThread().threadId() + "): ";
		
		System.out.println(threadInfo + "START");
		for (int i = 0; i <= n; i++) {
			System.out.println(threadInfo + i);
		}
		System.out.println(threadInfo + "END");
	}
}
