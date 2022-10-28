package Engine.State;

import Engine.Graphics.World;
import Engine.Handler;

import java.awt.*;

public class WorldState extends State {
    private World world;

    public WorldState(Handler handler){
        super(handler);
        world = new World("res/world/world1.txt");
        handler.setWorld(world);
    }

    @Override
    public void update() {
        world.update();
    }

    @Override
    public void render(Graphics g) {
        world.render(g);
    }
}
