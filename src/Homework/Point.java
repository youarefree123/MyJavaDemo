package Homework;

public class Point{ //坐标点类
    private int x,y;

    public Point(){
    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point getPoint(){
        Point p = new Point(x,y);
        return p;
    }

    @Override
    public String toString(){
        return "["+x+","+y+"]";
    }

    @Override
    public int hashCode() {
        return ( (5*x) + (7*y) );
    }

    public int getX(){
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

}