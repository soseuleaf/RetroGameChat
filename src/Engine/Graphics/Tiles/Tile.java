package Engine.Graphics.Tiles;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	public static Tile[] tiles = new Tile[100];
	public static Tile ground = new GroundTile(0);
	public static Tile luWall = new WallTile(1);
	public static Tile cuWall = new WallTile(2);
	public static Tile ruWall = new WallTile(3);
	public static Tile lcWall = new WallTile(4);
	public static Tile ldWall = new WallTile(5);
	public static Tile cdWall = new WallTile(6);
	public static Tile rdWall = new WallTile(7);
	public static Tile rcWall = new WallTile(8);
	public static Tile fWall = new WallTile(9);
	public static Tile chest = new TempChest(99);

	public static final int TILE_WIDTH = 64, TILE_HEIGHT = 64;
	
	protected BufferedImage texture;
	protected final int ID;
	
	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.ID = id;
		tiles[id] = this;
	}
	
	public void update() {
		
	}
	
	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILE_WIDTH, TILE_HEIGHT, null);
	}
	
	public boolean isSolid() {
		return false;
	}
	
	public int getID() {
		return this.ID;
	}
}

