package Experiment_12;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;


public class Ball
{
    private static final int XSIZE = 15;
    private static final int YSIZE = 15;
    private double x = 0;
    private double y = 0;
    private double dy = 0;
    private static final double g = 0.09;
    private double ke = 0;//动能
    private double pe = 0;//势能
    private double allEn; //所有能量
    private double m = 1;
    public Ball(int x,int y){
        this.x=x;
        this.y=y;
    }

    public void move(Rectangle2D bounds)
    {
        dy += g;
        y += dy;
        ke = 0.5*dy*dy*m;
        pe = m*(bounds.getHeight()-y)*g*100;
        setAllen(ke + pe);
        if (y + YSIZE >= bounds.getMaxY()) //如果到底了，速度反向
        {
            y = bounds.getMaxY() - YSIZE;
            dy = -dy;
            dy = dy*0.8;
        }
    }

    public void setAllen(double en){
        allEn = en;
    }
    public Ellipse2D getShape()
    {
        return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
    }

    public double getY() {
        return y;
    }

    public double getAllEn() {
        return allEn;
    }

    public void setAllEn(double allN) {
        this.allEn = allN;
    }
}
