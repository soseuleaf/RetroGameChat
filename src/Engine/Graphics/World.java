package Engine.Graphics;

import Engine.Graphics.Tiles.Tile;

import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class World {
	private int width, height;
	private int spawnX, spawnY;
	private int[][] mapArray;

	public World(String path) throws FileNotFoundException {
		loadWorld(path);
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g) {
		int xStart = 0;
		int xEnd = width;
		int yStart = 0;
		int yEnd = height;

		for(int x = xStart; x < xEnd; x++) {
			for(int y = yStart; y < yEnd; y++) {
				getTile(y,x).render(g, y * Tile.TILE_HEIGHT, x * Tile.TILE_WIDTH);
			}
		}
	}
	
	public Tile getTile(int y, int x) {
		Tile t = Tile.tiles[mapArray[y][x]];
		if(t == null) {
			return Tile.tiles[0];
		}
		return t;
	}
	
	private void loadWorld(String path) throws FileNotFoundException {
		Scanner scanner = new Scanner(new FileReader(path));
		width = scanner.nextInt();
		height = scanner.nextInt();
		mapArray = new int[height][width];

		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				mapArray[y][x] = scanner.nextInt();
			}
		}
	}
}
