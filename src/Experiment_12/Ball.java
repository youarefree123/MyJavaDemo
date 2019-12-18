package Experiment_12;

import java.awt.geom.*;

/**
 * A ball that moves and bounces off the edges of a rectangle
 * @version 1.33 2007-05-17
 * @author Cay Horstmann
 */
public class Ball
{
    private static final int XSIZE = 15;
    private static final int YSIZE = 15;
    private final double loss = 0.8;
    private static final int g = 90;
    private double x = 0;
    private double y = 0;
    private double v = 0;
    private double dx = 1;
    private double dy = 1;

    /**
     * Moves the ball to the next position, reversing direction if it hits one of the edges
     */
//    public void move(Rectangle2D bounds)
//    {
////        x += dx;
//        y += dy;
////        if (x < bounds.getMinX())
////        {
////            x = bounds.getMinX();
////            dx = -dx;
////        }
////        if (x + XSIZE >= bounds.getMaxX())
////        {
////            x = bounds.getMaxX() - XSIZE;
////            dx = -dx;
////        }
//        if (y < bounds.getMinY())
//        {
//            y = bounds.getMinY();
//            dy = -dy;
//        }
//        if (y + YSIZE >= bounds.getMaxY())
//        {
//            y = bounds.getMaxY() - YSIZE;
//            dy = -dy;
//        }
//    }

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
        //energe = 1*g*(bounds.getMaxY()-y)+0.5*1*v*v;
    }

    /**
     * Gets the shape of the ball at its current position.
     */
    public Ellipse2D getShape()
    {
        return new Ellipse2D.Double(x, y, XSIZE, YSIZE);
    }
}
