package main;


public class Player {

	private Vec2D coords;
	private Direction dir;
	
	public Player(int x, int y, Direction dir) {
		this.coords = new Vec2D(x, y);
		this.dir = dir;
	}
	
	/**
	 * Moves players location by one towards the direction the player is facing.
	 */
	public void move() {
		coords.add(dir.toVec());
	}
	
	public void face(Direction dir) {
		this.dir = dir;
	}
	
	public Vec2D getCoords() {
		return this.coords;
	}
	
	public Direction getDir() {
		return this.dir;
	}
	
}
