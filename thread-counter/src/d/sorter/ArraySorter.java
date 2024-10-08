package d.sorter;

public class ArraySorter {
	static int trheadCount = 4;
	
	public static int[] simpleSort(int[] array) {
		int[] sortedArray = array.clone();
		SorterUnit sorter = new SorterUnit(sortedArray, 0, sortedArray.length);
		sorter.run();
		return sortedArray;
	}
	
	public static int[] multiSort(int[] array) {
		Thread[] threads = new Thread[trheadCount];
		int[] sortedArray = array.clone();
		
		int segmentSize = sortedArray.length / trheadCount;
		for (int i = 0; i < trheadCount; i++) {
			threads[i] = new Thread(new SorterUnit(sortedArray, segmentSize * i, segmentSize));
			threads[i].setName("Sort-" + i);
		}
		
		for (int i = 0; i < trheadCount; i++) {
			threads[i].start();
		}
		
		for (int i = 0; i < trheadCount; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return simpleSort(sortedArray);
	}
}