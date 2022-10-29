package Engine.State;

import Engine.Handler;
import GameObject.Chat;
import java.awt.*;

public class MenuState extends State {
	private static Chat chat;

	public MenuState(Handler handler) {
		super(handler);
		chat = new Chat(handler);
	}
	
	@Override
	public void update() {
		chat.update();
	}

	@Override
	public void render(Graphics g) {
		chat.render(g);
	}
}
