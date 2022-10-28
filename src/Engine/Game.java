package Engine;

import Engine.Graphics.Display;
import Engine.State.*;
import GameObject.Assets;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
    private Display display;
    private final int width;
    private final int height;
    private final String title;

    private boolean running = false;
    private Thread gameThread;

    private final int FPS = 60;

    //States
    private final StateManager stateManager = new StateManager();

    //Input
    private final KeyManager keyManager = new KeyManager();

    //Handler
    private final Handler handler = new Handler(this);

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        init();
    }

    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();

        /* add 순서 지킬 것*/
        stateManager.addState(new WorldState(handler));
        stateManager.addState(new PlayerState(handler));
        stateManager.addState(new MenuState(handler));
    }

    private void update() {
        keyManager.update();
        stateManager.update();
    }

    private void render() {
        BufferStrategy bs = display.getCanvas().getBufferStrategy();
        if(bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, width, height);
        //Draw
        stateManager.render(g);
        //End Drawing
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        double drawInterval = 1_000_000_000.0 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                render();
                delta--;
            }
        }
    }

    public KeyManager getKeyManager() {
        return this.keyManager;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public synchronized void start() {
        if(!running) {
            running = true;
            gameThread = new Thread(this);
            gameThread.start();
        }
    }

    public synchronized void stop() {
        if(running) {
            running = false;
            try {
                gameThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
