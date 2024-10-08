package a;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Thread> threads = new ArrayList<Thread>();
		int t, n;			

		Scanner in = new Scanner(System.in);
		System.out.println("Es. A\n-----");
		System.out.print("Numero threads: ");
		t = in.nextInt();
		System.out.print("Valore massimo: ");
		n = in.nextInt();
		System.out.println();
		in.close();
		
		
		for (int i = 0; i < t; i++) {
			threads.add(new Thread(new Counter(n)));
			threads.getLast().setName("Count-" + i);
		}
		
		for (int i = 0; i < t; i++) {
			threads.get(i).start();
		}
	}
}
