package e12;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball {
    private double x;
    private double y;
    private double v;
    private double g;
    private int width;
    private int height;
    private final double loss = 0.8;
    private final double weight = 1;
    private double energe = 0;
    private	Color color;
    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        g = 90;
        v = 0;
        width = 10;
        height = 10;
        color = Color.GRAY;
    }

    public void move(double t, Rectangle2D bounds) {
        double old = v;
        v += g*t;
        double dy = 0.5*(old+v)*t;
        if (y+dy >= bounds.getMaxY()) {
            y = bounds.getMaxY();
            v = -1*loss*v;
        }
        else {
            y = (y+dy);
        }
        energe = weight*g*(bounds.getMaxY()-y)+0.5*weight*v*v;
    }
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        Ellipse2D b = new Ellipse2D.Double(x-width/2, y-height/2, width, height);
        g2.setColor(color);
        g2.fill(b);
        g2.setColor(Color.BLACK);
        g2.draw(b);
    }
    public double getEnerge() {
        return energe;
    }
    public void setEnerge(double energe) {
        this.energe = energe;
    }

    public double getY() {
        return y;
    }

    public void setColor(Color c) {
        this.color =c;
    }

}
