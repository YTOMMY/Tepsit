package b;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		ArrayList<Thread> threads = new ArrayList<Thread>();
		int t, n, d;			

		Scanner in = new Scanner(System.in);
		System.out.println("Es. B\n-----");
		System.out.print("Numero threads: ");
		t = in.nextInt();
		System.out.print("Valore massimo: ");
		n = in.nextInt();
		System.out.print("Tempo di attesa (ms): ");
		d = in.nextInt();
		System.out.println();
		in.close();
		
		
		for (int i = 0; i < t; i++) {
			threads.add(new Thread(new Counter(n, d, !(i%2==0))));
			String name;
			if(i % 2 == 0) name = "Ord-";
			else name = "Rev-";
			threads.getLast().setName(name + (i/2));
		}
		
		for (int i = 0; i < t; i++) {
			threads.get(i).start();
		}
	}
}
