package GameObject;

import Engine.Graphics.ImageLoader;
import Engine.Graphics.SpriteSheet;

import java.awt.image.BufferedImage;

public class Assets {
	private static final int tileWidth = 16, tileHeight = 16;
	private static final int characterWidth = 128, characterHeight = 128;
	public static BufferedImage ground;
	public static BufferedImage chest;
	public static BufferedImage[] idle_left, idle_right, move_left, move_right, walls;

	public static void init() {
		SpriteSheet playerSprites = new SpriteSheet(ImageLoader.loadImage("/textures/char_black.png"));
		SpriteSheet tiles = new SpriteSheet(ImageLoader.loadImage("/textures/dungeon_tiles_formatted_v2.png"));

		idle_left = new BufferedImage[1];
		idle_right = new BufferedImage[1];
		move_left = new BufferedImage[8];
		move_right = new BufferedImage[8];
		walls = new BufferedImage[10]; // 헷갈려서 1번부터 시작함

		spriteHelper(idle_left, playerSprites, 0, 0, characterWidth, characterHeight, false);
		spriteHelper(idle_right, playerSprites, 0, 0, characterWidth, characterHeight, false);
		spriteHelper(move_left, playerSprites, 1, 0, characterWidth, characterHeight, true);
		spriteHelper(move_right, playerSprites, 1, 0, characterWidth, characterHeight, false);

		ground = tiles.crop(1 * tileWidth, 1 * tileWidth, tileWidth, tileHeight).build();
		walls[1] = tiles.crop(0 * tileWidth, 0 * tileWidth, tileWidth, tileHeight).build();
		walls[2] = tiles.crop(1 * tileWidth, 0 * tileWidth, tileWidth, tileHeight).build();
		walls[3] = tiles.crop(4 * tileWidth, 0 * tileWidth, tileWidth, tileHeight).build();
		walls[4] = tiles.crop(0 * tileWidth, 1 * tileWidth, tileWidth, tileHeight).build();
		walls[5] = tiles.crop(0 * tileWidth, 4 * tileWidth, tileWidth, tileHeight).build();
		walls[6] = tiles.crop(1 * tileWidth, 4 * tileWidth, tileWidth, tileHeight).build();
		walls[7] = tiles.crop(4 * tileWidth, 4 * tileWidth, tileWidth, tileHeight).build();
		walls[8] = tiles.crop(4 * tileWidth, 1 * tileWidth, tileWidth, tileHeight).build();
		walls[9] = tiles.crop(8 * tileWidth, 4 * tileWidth, tileWidth, tileHeight).build();
		chest = tiles.crop(0 * tileWidth, 11 * tileWidth, tileWidth, tileHeight).build();
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
