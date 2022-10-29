package Engine.Graphics;

import GameObject.Assets;

import java.awt.Graphics;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class World {
	private int width, height;
	private int spawnX, spawnY;
	private int[][] mapArray;
	private int[][] mapFeat;

	public World(String path, String path2) throws FileNotFoundException {
		loadWorld(path, path2);
		for(int i = 0; i< Assets.tile_array.length; i++){
			new Tile(Assets.tile_array[i], i);
		}
		new Tile(Assets.tile_array[511], 511);
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
		if(x < 0 || y < 0 || width <= x || height <= y){
			return Tile.tiles[511];
		}
		else{
			Tile t = Tile.tiles[mapArray[y][x]];
			if(t == null) {
				return Tile.tiles[511];
			}
			return t;
		}
	}

	public boolean getSolid(int y, int x){
		if(x >= width || y >= height || x < 0 || y < 0) return true;
		return (mapFeat[y][x] == 0);
	}

	public int getTileFeat(int y, int x){
		if(x >= width || y >= height || x < 0 || y < 0) return 0;
		return mapFeat[y][x];
	}
	
	private void loadWorld(String path, String featSolid) throws FileNotFoundException {
		Scanner tileScanner = new Scanner(new FileReader(path));
		Scanner featScanner = new Scanner(new FileReader(featSolid));
		width = tileScanner.nextInt();
		height = tileScanner.nextInt();
		mapArray = new int[height][width];
		mapFeat = new int[height][width];

		for(int x = 0; x < width; x++) {
			for(int y = 0; y < height; y++) {
				mapArray[y][x] = tileScanner.nextInt();
				mapFeat[y][x] = featScanner.nextInt();
			}
		}
	}
}
