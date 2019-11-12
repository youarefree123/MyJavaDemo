package Homework;

public class oval extends Shape { //椭圆类
    public oval(int x1,int y1,int x2,int y2,String color) {
        super(new Point(x1,y1),new Point(x2,y2),color);
    }
    @Override
    public void draw() {
        System.out.println("以"+getP1()+"为外包矩形左上角点,"+getP2()+"为外包矩形右上角点画一个"+getColor()+"的椭圆");
    }

}