package GameObject;

import Engine.Graphics.Tile;
import Engine.Handler;

import java.awt.*;

public abstract class Creature extends Entity {
	public static final float DEFAULT_SPEED = 3.0f;

	protected Handler handler;
	protected float speed;
	protected float xMove, yMove;
	protected Rectangle bounds;
	protected boolean lastDirect = true;
	
	public Creature(Handler handler, int x, int y, int width, int height) {
		super(x, y, width, height);
		this.speed = DEFAULT_SPEED;
		this.xMove = 0;
		this.yMove = 0;
		this.handler = handler;
		this.bounds = new Rectangle(0, 0, width, height);
	}
	
	public void move() {
		moveX();
		moveY();
	}
	
	public void moveX() {
		if(xMove > 0) {
			tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;

			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
				x += xMove;
			}
			else {
				x = tx * Tile.TILE_WIDTH - bounds.x - bounds.width - 1;
			}
		}
		else if(xMove < 0) {
			tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;

			if(x < -bounds.x){ // 맵 밖으로 탈출 임시 방편...
				x = -bounds.x;
			}

			if(!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) &&
					!collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
				x += xMove;
			}
			else {
				x = tx * Tile.TILE_WIDTH + bounds.x + bounds.width;
			}
		}
	}
	
	public void moveY() {
		//Moving up
		if(yMove < 0) {
			ty = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;

			if(y < -bounds.y){ // 맵 밖으로 탈출 임시 방편...
				y = -bounds.y;
			}
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
				y += yMove;
			}
			else {
				y = ty * Tile.TILE_HEIGHT + bounds.height + bounds.y;
			}
		}
		//Moving down
		else if(yMove > 0) {
			ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
				y += yMove;
			}
			else {
				y = ty * Tile.TILE_HEIGHT - bounds.height - bounds.y - 1;
			}
		}
	}
	
	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getSolid(x, y);
	}

	public float getxMove() {
		return xMove;
	}
	public void setxMove(float xMove) {
		this.xMove = xMove;
	}
	public float getyMove() {
		return yMove;
	}
	public void setyMove(float yMove) {
		this.yMove = yMove;
	}
}
