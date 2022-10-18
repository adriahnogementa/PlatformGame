package main;

import inputs.KeybordInputs;
import inputs.MouseInputs;
import utils.PlayerConstants;

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
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 24;
    private int playerAction = PlayerConstants.IDLE.;

    public GamePanel() {
        mouseInputs = new MouseInputs(this);

        importImg();
        loadAnimations();
        setPanelSize();
        addKeyListener(new KeybordInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void loadAnimations() {
        animations = new BufferedImage[9][6];

        for (int j = 0; j < animations.length; j++) {


            for (int i = 0; i < animations[j].length; i++) {

                animations[j][i] = img.getSubimage(i * 64, j*40, 64, 40);
            }

        }
    }
    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed ){

            aniTick = 0;
            aniIndex++;
            if (aniIndex>= 6){
                aniIndex = 0;
            }
        }
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/player_sprites.png");

        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                is.close();

            } catch (IOException e) {

                e.printStackTrace();
            }
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

        updateAnimationTick();
        g.drawImage(animations[1][aniIndex],(int) xDelta, (int) yDelta,128,80,null);



    }



}

