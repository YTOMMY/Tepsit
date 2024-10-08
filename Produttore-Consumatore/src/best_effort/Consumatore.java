package best_effort;
import java.util.ArrayList;
 
public class Consumatore implements Runnable{
	Buffer buffer;
		
	public Consumatore(Buffer buffer) {
		this.buffer = buffer;
	}
	
	public void run() {
		int neg = 0;
		float media = 0;
		ArrayList<Integer> numPos = new ArrayList<Integer>();
		while(true) {
			int value = buffer.remove();
			if(value > 0) {
				numPos.add(value);
				if(numPos.size() > 5) {
					numPos.removeFirst();
				}
				media = 0;
				for(int i = 0; i < numPos.size(); i++) {
					media += numPos.get(i);
				}
				media /= numPos.size();
			}
			else {
				neg++;
			}
			System.out.println("--------------------------------\n" +
					Thread.currentThread().getName() + ": \n" +
					"Numero: " + value + "\n" +
					"Negativi: " + neg + "\n" + 
					"Media Positivi: " + media + "\n");
		}
	}
}