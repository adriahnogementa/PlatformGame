package main;

import inputs.KeybordInputs;
import inputs.MouseInputs;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private double xDelta=200, yDelta=200;
    private double xDir=1,yDir=1;

    public GamePanel() {
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeybordInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
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

        updateRectangle();
        g.setColor(Color.MAGENTA);
        g.fillRect((int)xDelta,(int)yDelta,400,400);



    }

    private void updateRectangle() {

        xDelta+= xDir;
        if(xDelta > 800 || xDelta < 0) {

            xDir*=-1;
        }

        yDelta+=yDir;
        if (yDelta > 800 || yDelta < 0){

            yDir*=-1;
        }
    }
}
