package main;

import javax.swing.*;

public class GameWindow extends JFrame {

    private JFrame jFrame;
    public GameWindow(GamePanel gamePanel){

        jFrame = new JFrame();

        jFrame.setSize(800,800);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.add(gamePanel);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);

    }
}

