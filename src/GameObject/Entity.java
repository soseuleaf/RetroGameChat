package GameObject;

import Engine.Handler;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class Entity {
	protected Handler handler;
	protected int x, y;
	protected int width, height;
	protected Rectangle bounds;
	
	public Entity(Handler handler, int x, int y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		
		bounds = new Rectangle(0, 0, width, height);
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

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public abstract void update();
	
	public abstract void render(Graphics g);
}
