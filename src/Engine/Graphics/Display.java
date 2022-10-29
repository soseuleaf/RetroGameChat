package Engine.Graphics;

import GameObject.Chat;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

public class Display {
    private JFrame frame;
    private Canvas canvas;
    private TransparentTextField textField;

    private final String title;
    private final int width;
    private final int height;

    public Display(String title, int width, int height) {
        this.title = title;
        this.width = width;
        this.height = height;
        createDisplay();
    }

    private void createDisplay() {
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setFocusable(true);
        frame.addKeyListener(new frameKeyEvent());

        Container c = frame.getContentPane();
        c.setLayout(null);

        textField = new TransparentTextField("");
        textField.setLocation(10, 710);
        textField.setSize(400,30);
        c.add(textField);

        canvas = new Canvas();
        canvas.setFocusable(false);
        canvas.setLocation(0, 0);
        canvas.setSize(width, height);
        c.add(canvas);

        frame.setVisible(true);
    }

    public Canvas getCanvas() {
        return this.canvas;
    }

    public JFrame getFrame() {
        return this.frame;
    }

    private class frameKeyEvent extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            if(keyCode == KeyEvent.VK_ENTER){
                System.out.println("넘기긱");
                textField.requestFocus();
            }
        }
    }

    public class TransparentTextField extends JTextField {
        public TransparentTextField(String text) {
            super(text);
            init();
        }

        protected void init() {
            addKeyListener(new textfieldKeyEvent());
            setOpaque(true);
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
            setToolTipText("채팅을 입력 하세요.");
            Font font = new Font("맑은 고딕", Font.BOLD, 20);
            setFont(font);
        }

        private class textfieldKeyEvent extends KeyAdapter {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                if(keyCode == KeyEvent.VK_ENTER){
                    if(!textField.getText().equals("")) {
                        Chat.addChat(textField.getText());
                        textField.setText("");
                        frame.requestFocus();
                    }
                }
            }
        }
    }
}
