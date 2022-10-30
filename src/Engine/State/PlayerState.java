package Engine.State;

import Engine.Handler;
import GameObject.Player;
import GameObject.User;

import java.awt.*;

public class PlayerState extends State {
    private final Player player;
    private final User user1;

    public PlayerState(Handler handler){
        super(handler);
        player = new Player(handler, 500, 500);
        user1 = new User("안녕", 500, 500);
    }

    @Override
    public void update() {
        player.update();
        user1.update();
    }

    @Override
    public void render(Graphics g) {
        user1.render(g);
        player.render(g);
    }
}
