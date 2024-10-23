package Magazzino;

import java.util.ArrayList;

public class Zona {
	
	String nome;
	int cap;
	ArrayList<Collo> colli;
	
	public Zona(String nome, int capienza) {
		this.nome = nome;
		this.cap = capienza;
		this.colli = new ArrayList<Collo>();
	}
	
	public String getNome() {
		return nome;
	}
	
	public synchronized int aggiungi(Collo collo) {
		if(colli.size() >= cap) {
			return -1;
		}
		colli.add(collo);
		return colli.size() - 1;
	}
}
