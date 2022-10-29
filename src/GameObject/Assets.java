package GameObject;

import Engine.Graphics.ImageLoader;
import Engine.Graphics.SpriteSheet;

import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;

public class Assets {
	private static final int tileWidth = 16, tileHeight = 16;
	private static final int characterWidth = 128, characterHeight = 128;
	public static BufferedImage ground;
	public static BufferedImage chest;
	public static BufferedImage[] idle_left, idle_right, move_left, move_right;
	public static BufferedImage[] tile_array;

	public static void init() {
		SpriteSheet playerSprites = new SpriteSheet(ImageLoader.loadImage("/textures/char_black.png"));
		SpriteSheet tiles = new SpriteSheet(ImageLoader.loadImage("/textures/pokemon_tile.png"));

		idle_left = new BufferedImage[1];
		idle_right = new BufferedImage[1];
		move_left = new BufferedImage[8];
		move_right = new BufferedImage[8];
		tile_array = new BufferedImage[512];

		spriteHelper(idle_left, playerSprites, 0, 0, characterWidth, characterHeight, true);
		spriteHelper(idle_right, playerSprites, 0, 0, characterWidth, characterHeight, false);
		spriteHelper(move_left, playerSprites, 1, 0, characterWidth, characterHeight, true);
		spriteHelper(move_right, playerSprites, 1, 0, characterWidth, characterHeight, false);

		int i = 0;
		for(int y = 0; y < 15; y++){
			for(int x = 0; x < 18; x++){
				tile_array[i++] = tiles.crop(x*tileWidth, y*tileHeight, tileWidth, tileHeight).build();
			}
		}
		tile_array[511] = new BufferedImage(16, 16, 1);
	}

	private static void spriteHelper(BufferedImage[] bufferedImages, SpriteSheet s, int x, int y, int width, int height, boolean flip){
		for(int i = 0; i < bufferedImages.length; i++, x++){
			s.crop(x * width, y * height, width, height);
			if(flip){
				s.flipX();
			}
			bufferedImages[i] = s.build();
		}
	}
}
