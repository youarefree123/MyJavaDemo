package Experiment_12;

import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.*;


public class BounceComponent extends JComponent
{
    private List<Ball> allBall = new ArrayList<>();
    private double allEn = 0;
    public void add(Ball b)
    {
        allBall.add(b);
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        Ball maxBall = new Ball(0,10000); //假定一个最底部的球
        for(Ball b:allBall) {
            if(b.getY()<maxBall.getY()) { //如果有球在这个假象球的上面
                maxBall=b;
                allEn += b.getAllEn();
            }
        }
        for (Ball b:allBall)
        {
            if(b==maxBall) {
                g2.setColor(Color.RED);
                g2.fill(b.getShape());
                g2.setColor(Color.black);
            }
            else {
                g2.fill(b.getShape());
            }
        }
    }

    public double getAllEn() {
        return allEn;
    }

    public void setAllEn(double allEn) {
        this.allEn = allEn;
    }

//        public Dimension getPreferredSize() { return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT); }
}



