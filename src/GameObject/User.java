package GameObject;

import Engine.Graphics.Animation;
import Engine.Handler;

import java.awt.*;

public class User extends Entity{
    private Animation animIdleRight;
    protected String name;

    public User(String name, int x, int y) {
        super(x, y, DEFAULT_CREATURE_WIDTH, DEFAULT_CREATURE_HEIGHT);
        this.name = name;
        this.x = x;
        this.y = y;
        animIdleRight = new Animation(999, Assets.idle_right);
        currentAni = animIdleRight;
    }

    @Override
    public void update() {
        if(currentAni != null) {
            currentAni.update();
        }
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(currentAni.getCurrentFrame(), x, y, width, height, null);
        g.drawString("유저1", x, y);
    }
}
