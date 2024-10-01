package Teatro.Sale;

public class Sala {
	private char[][] posti;
	private boolean spettacolo;
	
	public Sala(int file, int postiFila) {
		posti = new char[file][postiFila];
		spettacolo = false;
		clear();
	}
	
	public int y() {
		return posti.length;
	}
	
	public int x() {
		return posti[0].length;
	}
	
	public void inizioSpettacolo() {
		spettacolo = true;
	}
	
	public synchronized void clear() {
		for(int i = 0; i < posti.length; i++) {
			for(int j = 0; j < posti[0].length; j++) {
				posti[i][j] = 'X';
			}
		}
	}
	
	public synchronized char[][] getPosti() {
		return posti;
	}
 
	public synchronized boolean checkPosto(Point posto) {
		return posti[posto.getY()][posto.getX()] == 'X';
	}
	
	public synchronized boolean prenotaPosto(char id, Point posto) {
		if(!spettacolo ) {
			Point p = posto.Clone();
			while(!checkPosto(p)) {
				int x = p.getX() + 1;
				if(x / posti[0].length >= 1) {
					x %= posti[0].length;
					int y = p.getY() + 1;
					if(y / posti.length >= 1) {
						return false;
					}
					p.setY(y);
				}
				p.setX(x);
			}
			posti[p.getY()][p.getX()] = id;
			return true;
		}
		return false;
	}
}
 