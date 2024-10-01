package StatoDeiThread.Main;

import StatoDeiThread.Counter.Counter;
import StatoDeiThread.Counter.Number;

import java.util.Random;
import java.util.Scanner;

public class Main {

	static int attesaThread = 120;
	static int attesaPrint = 750;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T, N;
		
		System.out.print("Numero Thread (T): ");
		T = scanner.nextInt();
		System.out.print("Numero Massimo (N): ");
		N = scanner.nextInt();
		scanner.close();
		
		Thread[] threads = new Thread[T];
		Number[] values = new Number[T];
		
		Random rand = new Random();
		for(int i = 0; i < T; i++) {
			values[i] = new Number();
			threads[i] = new Thread(new Counter(values[i], Math.abs(rand.nextInt()) % N, attesaThread));
		}
		for(int i = 0; i < T; i++) {
			threads[i].start();
		}
		
		while(threadCheck(threads)) {
			printValues(threads, values);
			try {
				Thread.sleep(attesaPrint);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("-----------------------------");
		System.out.println("TUTTI I THREAD COMPLETATI");
	}
	
	static void printValues(Thread[] threads, Number[] values) {
		System.out.println("-----------------------------");
		for(int i = 0; i < threads.length; i++) {
			System.out.print(threads[i].getName() + " (" + threads[i].threadId() + "): ");
			if(threads[i].isAlive()) {
				System.out.println(values[i].Get());
			} else {
				System.out.println("COMPLETATO");
			}
		}
	}
	
	static boolean threadCheck(Thread[] threads) {
		boolean isAlive = false;
		for(int i = 0; i < threads.length; i++) {
			isAlive = isAlive || threads[i].isAlive();
		}
		return isAlive;
	}
}
