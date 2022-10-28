package Engine.State;

import Engine.Handler;
import GameObject.Player;

import java.awt.*;

public class PlayerState extends State {
    private final Player player;

    public PlayerState(Handler handler){
        super(handler);
        player = new Player(handler, 100, 100);
    }

    @Override
    public void update() {
        player.update();
    }

    @Override
    public void render(Graphics g) {
        player.render(g);
    }
}
