package Homework.ex4_2;

public class Cylinder implements C{
    private double radius ; //底圆半径
    private double height ; //圆柱体高
    private String color ; //圆柱体颜色

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
    public Cylinder(double radius, double height, String color) {
        this.radius = radius;
        this.height = height;
        this.color = color;
    }

    public void print(){
        volume();
        System.out.println("颜色为"+color);
    }
    @Override
    public void volume() {
        System.out.println("圆柱体的体积为:"+area()*height);
    }

    @Override
    public double area() {
        return PI*radius*radius;
    }

    @Override
    public void setColor(String c) {
        this.color = c;
    }


}

