package main;

public class Vec2D {
	public int x;
	public int y;
	
	/**
	 * Constructs a vector with x,y = 0.
	 */
	public Vec2D() {
		this(0,0);
	}
	
	public Vec2D(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void add(Vec2D v2) {
		this.x += v2.x;
		this.y += v2.y;
	}

}
