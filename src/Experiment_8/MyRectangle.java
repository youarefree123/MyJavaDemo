package Experiment_8;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class MyRectangle extends MyShape {

	public MyRectangle(int x1, int y1, int x2, int y2, Color color) {
		super(new MyPoint(x1, y1), new MyPoint(x2, y2), color);
	}

	public void Draw(Graphics2D g) {
		Rectangle2D.Double rect = new Rectangle2D.Double(getP1().getX(), getP1().getY(),
				getP2().getX() - getP1().getX(), getP2().getY() - getP1().getY());
		//Graphics2D g2 = (Graphics2D) g;
		g.setColor(getColor());
		g.fill(rect);
		g.setColor(Color.BLUE);
		g.draw(rect);
	}


	@Override
	public boolean IsContain(MyPoint p) { //判断是否被包含
		if (p.IsBig(getP2()) && p.IsSmall(getP1())) {
			return true;
		}
		return false;
	}

	

}