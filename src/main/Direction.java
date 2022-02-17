package main;

public enum Direction {

	UP,
	RIGHT,
	DOWN,
	LEFT;
	
	public int intValue() {
		int dir;
		
		switch (this) {
		case UP:
			dir = 0;
			break;
		case RIGHT:
			dir = 1;
			break;
		case DOWN:
			dir = 2;
			break;
		default: dir = 3;
		}
		
		return dir;
	}
	
	public Vec2D toVec() {
		int x = 0;
		int y = 0;
		
		switch (this) {
		case UP:
			y = 1;
			break;
		case RIGHT:
			x = 1;
			break;
		case DOWN:
			y = -1;
			break;
		default: x = -1;
		}
		
		return new Vec2D(x, y);
		
	}
	
}
