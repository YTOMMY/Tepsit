package d.sorter;

class SorterUnit implements Runnable{
	int[] array;
	int start, length;
	
	public SorterUnit(int[] array, int startIndex, int length) {
		this.array = array;
		this.start = startIndex;
		this.length = length;
	}
	
	public void run() {
		for(int i = 0; i < length - 1; i++) {
			for(int j = start; j < start + length - i - 1; j++) {
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}
}
