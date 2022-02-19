package main;

public class Entity {

	private Vec2D coords;
	private Direction dir;
	
	public Entity (int x, int y, Direction dir) {
		this.coords = new Vec2D(x, y);
		this.dir = dir;
	}
	
	/**
	 * Moves entity by one in facing direction
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
