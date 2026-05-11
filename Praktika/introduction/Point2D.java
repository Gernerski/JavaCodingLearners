package introduction;

public class Point2D {
	int x, y;
	
	public Point2D() {
		this(0,0);
	}
	
	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}

	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public Point2D add(Point2D addend) {
		this.x += addend.x;
		this.y += addend.y;
		
		return this;
	}
	
	public double getDistanceFromOrigin() {
		return Math.sqrt((x * x) + (y * y));
	}
}
