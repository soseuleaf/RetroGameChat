package GameObject;

import Engine.Handler;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class Chat {
    protected Handler handler;
    static Queue<String> queue = new LinkedList<>();

    public Chat(Handler handler) {
        this.handler = handler;
    }

    public void update(){

    }

    public void render(Graphics g){
        int x = 10;
        int y = 410;
        g.setColor(new Color(0, 0, 0, 200));
        g.fillRect(x, y, 400, 300);
        g.setColor(new Color(255, 255, 255));
        g.setFont(new Font("맑은 고딕", Font.BOLD, 20));

        String[] msgs = new String[11];
        for(int i = 0; i < queue.size(); i++){
            String tmp = queue.poll();
            msgs[i] = tmp;
            queue.offer(tmp);
        }

        for(int i = 0; i < 11; i++){
            if(msgs[i] != null)
                g.drawString(msgs[i], 20, 440 + i * 25);
        }
        g.dispose();
    }

    public static void addChat(String message){
        queue.offer(message);
        if(queue.size() > 11){
            queue.remove();
        }
    }
}
