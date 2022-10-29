package Engine.State;

import Engine.Graphics.World;
import Engine.Handler;

import java.awt.*;
import java.io.FileNotFoundException;

public class WorldState extends State {
    private World world;

    public WorldState(Handler handler) throws FileNotFoundException {
        super(handler);
        world = new World("res/worlds/world1.txt", "res/worlds/solid.txt");
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
