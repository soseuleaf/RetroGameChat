package GameObject;

import Engine.Graphics.ImageLoader;
import Engine.Graphics.SpriteSheet;

import java.awt.image.BufferedImage;

public class Assets {
	private static final int width = 128, height = 128;
	public static BufferedImage stone, wall;
	public static BufferedImage[] player_idle_left, player_idle_right, player_down, player_up, player_left, player_right;
	
	public static void init() {
		SpriteSheet playerSprites = new SpriteSheet(ImageLoader.loadImage("/textures/char_black.png"));
		SpriteSheet stones = new SpriteSheet(ImageLoader.loadImage("/textures/dungeon_tiles_formatted_v2.png"));

		player_idle_left = new BufferedImage[1];
		player_idle_right = new BufferedImage[1];
		player_down = new BufferedImage[8];
		player_up = new BufferedImage[8];
		player_left = new BufferedImage[8];
		player_right = new BufferedImage[8];

		player_idle_left[0] = playerSprites.crop(0, 0, width, height).flipX().build();
		player_idle_right[0] = playerSprites.crop(0, 0, width, height).build();

		player_up[0] = playerSprites.crop(width * 1, height * 3, width, height).build();
		player_up[1] = playerSprites.crop(width * 2, height * 3, width, height).build();
		player_up[2] = playerSprites.crop(width * 3, height * 3, width, height).build();
		player_up[3] = playerSprites.crop(width * 4, height * 3, width, height).build();
		player_up[4] = playerSprites.crop(width * 5, height * 3, width, height).build();
		player_up[5] = playerSprites.crop(width * 6, height * 3, width, height).build();
		player_up[6] = playerSprites.crop(width * 7, height * 3, width, height).build();
		player_up[7] = playerSprites.crop(width * 8, height * 3, width, height).build();
		
		player_left[0] = playerSprites.crop(width * 1, height * 0, width, height).flipX().build();
		player_left[1] = playerSprites.crop(width * 2, height * 0, width, height).flipX().build();
		player_left[2] = playerSprites.crop(width * 3, height * 0, width, height).flipX().build();
		player_left[3] = playerSprites.crop(width * 4, height * 0, width, height).flipX().build();
		player_left[4] = playerSprites.crop(width * 5, height * 0, width, height).flipX().build();
		player_left[5] = playerSprites.crop(width * 6, height * 0, width, height).flipX().build();
		player_left[6] = playerSprites.crop(width * 7, height * 0, width, height).flipX().build();
		player_left[7] = playerSprites.crop(width * 8, height * 0, width, height).flipX().build();
		
		player_right[0] = playerSprites.crop(width * 1, height * 0, width, height).build();
		player_right[1] = playerSprites.crop(width * 2, height * 0, width, height).build();
		player_right[2] = playerSprites.crop(width * 3, height * 0, width, height).build();
		player_right[3] = playerSprites.crop(width * 4, height * 0, width, height).build();
		player_right[4] = playerSprites.crop(width * 5, height * 0, width, height).build();
		player_right[5] = playerSprites.crop(width * 6, height * 0, width, height).build();
		player_right[6] = playerSprites.crop(width * 7, height * 0, width, height).build();
		player_right[7] = playerSprites.crop(width * 8, height * 0, width, height).build();

		player_down[0] = playerSprites.crop(width * 1, height * 2, width, height).build();
		player_down[1] = playerSprites.crop(width * 2, height * 2, width, height).build();
		player_down[2] = playerSprites.crop(width * 3, height * 2, width, height).build();
		player_down[3] = playerSprites.crop(width * 4, height * 2, width, height).build();
		player_down[4] = playerSprites.crop(width * 6, height * 2, width, height).build();
		player_down[5] = playerSprites.crop(width * 7, height * 2, width, height).build();
		player_down[6] = playerSprites.crop(width * 6, height * 2, width, height).build();
		player_down[7] = playerSprites.crop(width * 4, height * 2, width, height).build();

		stone  = stones.crop(0, 0, 64, 64).build();
		//wall = stones.crop(1 * width, 5 * height, width, height);
		wall = new BufferedImage(64, 64, 1);
	}
}
