package Magazzino;

public class Addetto implements Runnable {

	String zona;
	Container[] containers;
	Zona[] zone;
	
	public Addetto(String zona, Container[] containers, Zona[] zone) {
		this.zona = zona;
		this.containers = containers;
		this.zone = zone;
	}
	
	public void run() {
		while(!containers[containers.length-1].isEmpty()) {
			int i = 0;
			for(; i < containers.length; i++) {
				if (!containers[i].isEmpty()) {
					break;
				}
			}
			Collo collo = containers[i].getCollo(zona);
			if(collo != null) {
				for(int j = 0; j < zone.length; j++) {
					if(zone[j].nome == collo.getDestinazione()) {
						int pos = zone[j].aggiungi(collo);
						if(pos != -1) {
							System.out.println(Thread.currentThread().getName() + ": Collo " + collo.id + " nella posizione " + pos + " di " + zone[j].getNome());
						}
						break;
					}
				}
			}
		}
	}

}
