package main;

import inputs.KeybordInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private double xDelta=200, yDelta=200;
    private BufferedImage img;

    public GamePanel() {
        mouseInputs = new MouseInputs(this);
        
        importImg();
        setPanelSize();
        addKeyListener(new KeybordInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");

        try {
            img= ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void setPanelSize() {
        setPreferredSize(new Dimension(1280,800));
    }

    public void changeXDelta(int value){
        xDelta += value;
    }

    public void changeYDelta(int value){
        yDelta += value;
    }

    public void setRectPos(Point point){
        this.xDelta =point.getX();
        this.yDelta=point.getY();

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

      g.drawImage(img.getSubimage(0,0,64,40),0,0,null);



    }

}

