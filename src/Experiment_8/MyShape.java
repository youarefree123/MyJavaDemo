package Experiment_8;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class MyShape {
	private MyPoint p1;
	private MyPoint p2;
	private Color color;

	public MyShape(MyPoint p1, MyPoint p2, Color color) {
		this.p1 = p1;
		this.p2 = p2;
		this.color = color;
	}


	public MyPoint getP1() {
		return p1;
	}

	public void setP1(MyPoint p1) {
		this.p1 = p1;
	}

	public MyPoint getP2() {
		return p2;
	}

	public void setP2(MyPoint p2) {
		this.p2 = p2;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public abstract void Draw(Graphics2D g);

	public abstract boolean IsContain(MyPoint p);

	public  void Move(int dx, int dy)
	{
		p1.setX(p1.getX()+dx);
		p1.setY(p1.getY()+dy);
		p2.setX(p2.getX()+dx);
		p2.setY(p2.getY()+dy);
	}
	
	public void update(MyPoint p) //更新坐标
	{   
		if(p.getX()<=p1.getX()||p.getY()<=p1.getY()) { //左上往右下更新
			p1.setX(p.getX());
			p1.setY(p.getY());
		}
		else { //右下往左上更新
			p2.setX(p.getX());
			p2.setY(p.getY());
		}
	}

}
