import Engine.Game;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Game game = new Game("RetroGameChat", 1280, 788);
        game.start();
    }
}
