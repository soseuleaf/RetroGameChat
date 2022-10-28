package Engine.Graphics;

import Engine.Handler;
import java.awt.Graphics;

public class World {
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	
	public World(String path) {
		loadWorld(path);
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g) {
		int xStart = 0;
		int xEnd = width;
		int yStart = 0;
		int yEnd = height;
		
		for(int y = yStart ; y < yEnd ; y++) {
			for(int x = xStart ; x < xEnd ; x++) {
				getTile(x,y).render(g, x * Tile.TILE_WIDTH, y * Tile.TILE_HEIGHT);
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		if( x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.stoneTile;
		}
		
		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null) {
			return Tile.stoneTile;
		}
		return t;
	}
	
	private void loadWorld(String path) {
		width = 5;
		height = 5;
		tiles = new int[width][height];
		
		for(int x = 0 ; x < width ; x++) {
			for(int y = 0 ; y < height ; y++) {
				tiles[x][y] = 0;
			}
		}
		tiles[3][3] = 1;
	}
}
