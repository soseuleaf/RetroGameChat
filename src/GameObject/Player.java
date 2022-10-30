package GameObject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import Engine.Graphics.Animation;
import Engine.Handler;

public class Player extends Creature {
	private Animation animLeft, animRight, animIdleLeft, animIdleRight;
	private float actionCooltime = 0;
	private final float maxCooltime = 60;

	public Player(Handler handler, int x, int y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		bounds.x = 16;
		bounds.y = 16;
		bounds.width = 32;
		bounds.height = 32;
		animLeft = new Animation(75, Assets.move_left);
		animRight = new Animation(75, Assets.move_right);
		animIdleLeft = new Animation(999, Assets.idle_left);
		animIdleRight = new Animation(999, Assets.idle_right);
	}

	@Override
	public void update() {
		if(currentAni != null) {
			currentAni.update();
		}
		if (actionCooltime > 0){
			actionCooltime--;
		}
		currentAni = getCurrentAnimation();
		getInput();
		getEvent();
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

	private void getEvent(){
		if(handler.getKeyManager().space && actionCooltime <= 0){
			int tileFeat = handler.getWorld().getTileFeat(tx, ty);
			if(tileFeat == 2){
				Random random = new Random();
				random.setSeed(System.currentTimeMillis());
				System.out.println("와! 랜덤한 번호" + random.nextInt(100));
			}
			actionCooltime = maxCooltime;
		}
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
	@Override
	public void render(Graphics g) {
		g.drawImage(currentAni.getCurrentFrame(), (int)x, (int)y, width, height, null);
		g.drawString("닉네임", x, y);
	}
}