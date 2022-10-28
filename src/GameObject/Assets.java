package GameObject;

import Engine.Graphics.ImageLoader;
import Engine.Graphics.SpriteSheet;

import java.awt.image.BufferedImage;

public class Assets {
	private static final int tileWidth = 16, tileHeight = 16;
	private static final int characterWidth = 128, characterHeight = 128;
	public static BufferedImage stone, wall;
	public static BufferedImage[] idle_left, idle_right, move_left, move_right;
	
	public static void init() {
		SpriteSheet playerSprites = new SpriteSheet(ImageLoader.loadImage("/textures/char_black.png"));
		SpriteSheet tiles = new SpriteSheet(ImageLoader.loadImage("/textures/dungeon_tiles_formatted_v2.png"));

		idle_left = new BufferedImage[1];
		idle_right = new BufferedImage[1];
		move_left = new BufferedImage[8];
		move_right = new BufferedImage[8];
		spriteHelper(idle_left, playerSprites, 0, 0, characterWidth, characterHeight, false);
		spriteHelper(idle_right, playerSprites, 0, 0, characterWidth, characterHeight, false);
		spriteHelper(move_left, playerSprites, 1, 0, characterWidth, characterHeight, true);
		spriteHelper(move_right, playerSprites, 1, 0, characterWidth, characterHeight, false);

		stone = tiles.crop(0, 0, tileWidth, tileHeight).build();
		wall = tiles.crop( 8 * tileWidth, 4 * tileHeight, tileWidth, tileHeight).build();
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
