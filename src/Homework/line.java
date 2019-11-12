package Homework;


public class line extends Shape { //直线类
    public line(int x1,int y1,int x2,int y2,String color) {
        super(new Point(x1,y1),new Point(x2,y2),color);
    }
    @Override
    public void draw() {
        System.out.println("以"+getP1()+"为起点,"+getP2()+"为中点画一条"+getColor()+"的直线");
    }

}