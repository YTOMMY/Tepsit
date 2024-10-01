package Teatro.Sale;

public class Point {
	private int x;
	private int y;
	
	public Point() {
		this(0, 0);
	}
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Point Clone() {
		return new Point(x, y);
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	public void setX(int x) { this.x = x; }
	public void setY(int y) { this.y = y; }
	
	/*
	public double distanza(Point point) {
		return distanza(this, point);
	}
	public static double distanza(Point a, Point b) {
		return Math.sqrt((b.x - a.x)^2 + (b.y - a.y));
	}
	*/
}