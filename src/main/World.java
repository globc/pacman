package main;

public class World {
	
	private int sizeX, sizeY;
	private int levelID;
	
	private int[][] map;
	
	public World(int levelID) {
		generate();
	}
	
	private void generate() {
		this.sizeX = 5;
		this.sizeY = 5;
		
		this.map = new int[this.sizeX][this.sizeY];
	}
	
}
