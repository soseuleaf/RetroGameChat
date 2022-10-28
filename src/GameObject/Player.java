package GameObject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Engine.Graphics.Animation;
import Engine.Handler;

public class Player extends Creature {
	private Animation animLeft, animRight, animIdleLeft, animIdleRight;
	private Animation currentAni;
	
	public Player(Handler handler, int x, int y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		
		bounds.x = 16;
		bounds.y = 16;
		bounds.width = 32;
		bounds.height = 32;
		animLeft = new Animation(75, Assets.move_left);
		animRight = new Animation(75, Assets.move_right);
		animIdleLeft = new Animation(90, Assets.idle_left);
		animIdleRight = new Animation(90, Assets.idle_right);
	}

	@Override
	public void update() {
		//Animations
		if(currentAni != null) currentAni.update();

		//Animations
		getInput();
		move();
	}
	
	private void getInput() {
		xMove = 0;
		yMove = 0;
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}
	
	@Override
	public void render(Graphics g) {
		currentAni = getCurrentAnimation();
		g.drawImage(currentAni.getCurrentFrame(), (int)x, (int)y, width, height, null);
		g.drawRect((int)x, (int)y, width, height);
	}
	
	private Animation getCurrentAnimation() {
		//If player is moving left
		if(xMove < 0) {
			lastDirect = false;
			return animLeft;
		}
		//If player is moving right
		else if(xMove > 0) {
			lastDirect = true;
			return animRight;
		}
		//If player is moving up
		else if (yMove < 0 || yMove > 0) {
			if (lastDirect) {
				return animRight;
			} else {
				return animLeft;
			}
		}
		//If player is moving not moving
		else {
			if (lastDirect) {
				return animIdleRight;
			} else {
				return animIdleLeft;
			}
		}
	}
}