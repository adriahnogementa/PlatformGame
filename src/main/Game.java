package main;

public class Game implements Runnable{

    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS_SET=60;

    public Game(){


        this.gamePanel = new GamePanel();
        this.gameWindow = new GameWindow(gamePanel);
        this.gamePanel.requestFocus();
        startGameLoop();
    }

    private void startGameLoop(){

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000 /FPS_SET;
        long lastFrame = System.nanoTime(), now = System.nanoTime();
        int frames = 0;
        long lastCheck = System.currentTimeMillis();


        while(true){
            now = System.nanoTime();
            if (now - lastFrame >= timePerFrame){
                gamePanel.repaint();
                lastFrame = now;
                frames++;
            }

            if (System.currentTimeMillis() - lastCheck >=1000){

                lastCheck = System.currentTimeMillis();
                System.out.println("FPS:" + " " + frames);
                frames = 0;
            }

        }
    }
}