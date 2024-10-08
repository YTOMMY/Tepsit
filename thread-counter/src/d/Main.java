package d;

import java.util.Scanner;
import d.sorter.ArraySorter;
import java.util.Random;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		int[] array;
		int n;

		Scanner in = new Scanner(System.in);
		System.out.println("Es. D\n-----");
		System.out.print("Lunghezza vettore: ");
		n = in.nextInt();
		System.out.println();
		in.close();
		
		array = randomArray(n);
		System.out.println("Array non ordinato:");
		//printArray(array);
		System.out.println("\nArray ordinato (senza Threads):");
		printArray(ArraySorter.simpleSort(array));
		System.out.println("\nArray ordinato (con i Threads):");
		printArray(ArraySorter.multiSort(array));
	}
	
	static int[] randomArray (int n) {

		Random rand = new Random();
		int[] array = new int[n];
		ArrayList<Integer> numberList = new ArrayList<Integer>();
		
		for(int i = 0; i < n; i++) {
			numberList.add(i);
		}
		
		for(int i = 0; i < n; i++) {
			int r = Math.abs(rand.nextInt()) % numberList.size();
			array[i] = numberList.get(r).intValue();
			numberList.remove(r);
		}
		
		return array;
	}	
	static void printArray (int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	static int checkArray(int[] array) {
		int errors = 0;
		for(int i = 0; i < array.length - 1; i++) {
			if(array[i]+1 != array[i+1]) errors++;
		}
		return errors;
	}
}
