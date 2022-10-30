package GameObject;

import Engine.Graphics.Animation;
import Engine.Handler;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {
	public static final int DEFAULT_CREATURE_WIDTH = 64;
	public static final int DEFAULT_CREATURE_HEIGHT = 64;
	protected int x, y;
	protected int tx, ty;
	protected int width, height;
	protected Animation currentAni;

	public Entity(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public float getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public float getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public abstract void update();
	
	public abstract void render(Graphics g);
}
