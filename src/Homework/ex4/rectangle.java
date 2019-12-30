package Homework.ex4;
public class rectangle extends Shape { //矩形类
    public rectangle(int x1,int y1,int x2,int y2,String color) {
        super(new Point(x1,y1),new Point(x2,y2),color);
    }
    @Override
    public String draw() {
        System.out.println("以"+getP1()+"为左上角点,"+getP2()+"为右上角点画一个"+getColor()+"的矩形");
        return null;
    }
}