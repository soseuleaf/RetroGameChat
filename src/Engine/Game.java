package Engine;

import Engine.Graphics.Display;
import Engine.State.MenuState;
import Engine.State.PlayerState;
import Engine.State.StateManager;
import Engine.State.WorldState;
import GameObject.Assets;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Game implements Runnable {
    private Display display;
    private final int width;
    private final int height;
    private final String title;

    private boolean running = false;
    private Thread thread;

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
        init();

        int fps = 60;
        double timePerupdate = 1000000000.0 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();

        long timer = 0;
        int updates = 0;

        while(running) {
            now = System.nanoTime();
            delta = (now - lastTime);
            timer += now - lastTime;

            if(delta >= timePerupdate) {
                lastTime = now;
                update();
                render();
                updates++;
                delta = 0;
            }

            if(timer >= 1000000000) {
                System.out.println(updates);
                updates = 0;
                timer = 0;
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
            thread = new Thread(this);
            thread.start();
        }
    }

    public synchronized void stop() {
        if(running) {
            running = false;
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
