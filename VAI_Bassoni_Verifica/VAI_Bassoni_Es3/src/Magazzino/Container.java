package Magazzino;

import java.util.ArrayList;

public class Container {
	
	ArrayList<Collo> colli;
	
	public Container(ArrayList<Collo> colli) {
		this.colli = colli;
	}
	
	public synchronized boolean isEmpty() {
		return colli.isEmpty();
	}
	
	public synchronized Collo getCollo(String zona) {
		if(isEmpty()) {
			return null;
		}
		for(int i = 0; i < colli.size(); i++) {
			if(colli.get(i).getDestinazione() == zona) {
				return colli.remove(i);
			}
		}
		return colli.removeFirst();
	}
}
