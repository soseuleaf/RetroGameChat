package Engine.State;

import Engine.Handler;

import java.awt.Graphics;
import java.util.Vector;

public class StateManager {
	private final Vector<State> stateVector = new Vector<>();

	public void addState(State state){
		stateVector.add(state);
	}

	public void update() {
		for(State state : stateVector){
			state.update();
		}
	}

	public void render(Graphics g) {
		for(State state : stateVector){
			state.render(g);
		}
	}
}
