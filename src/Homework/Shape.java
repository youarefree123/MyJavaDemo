package Homework;

public abstract class Shape{ //图形抽象类
    private String color ; //颜色
    private Point p1 , p2 ; //左上角坐标，右下角坐标

    public Shape(Point p1, Point p2,String color) {
        this.p1 = p1;
        this.p2 = p2;
        this.color = color;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public Point getP1(){
        return p1;
    }
    public void setP1(int x , int y) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }
    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public abstract void draw();

    @Override
    public  boolean equals(Object anObject){
        if(this == anObject)  //如果是同一个对象
        return true;
        if (this == null) //如果是空对象
            return false;
        if (this.getClass() != anObject.getClass()) //如果不是同一个类
            return false;
        return (this.hashCode() == anObject.hashCode());
    }

    @Override
    public int hashCode() {
        return ( 5*p1.hashCode() + 7*p2.hashCode() + 11*color.hashCode());
    }


    @Override
    public String toString() {
        return (this.getClass().getName()+"["+
                "x1="+getP1().getX()+",x2="+getP2().getX()+
                ",y1="+getP1().getY()+",y2="+getP2().getY()+
                ",color ="+getColor())+"]";
    }

}
