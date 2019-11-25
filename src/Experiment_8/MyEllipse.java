package Experiment_8;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class MyEllipse extends MyShape {

	public MyEllipse(int x1, int y1, int x2, int y2, Color color) {
		super(new MyPoint(x1, y1), new MyPoint(x2, y2), color);
	}

	@Override
	public void Draw(Graphics2D g) {
		Ellipse2D.Double ellipse = new Ellipse2D.Double(getP1().getX(), getP1().getY(), getP2().getX() - getP1().getX(),
				getP2().getY() - getP1().getY());
		//Graphics2D g2 = (Graphics2D) g;
		g.setColor(getColor());
		g.fill(ellipse);
		g.setColor(Color.BLUE);
		g.draw(ellipse);
	}

	@Override
	public boolean IsContain(MyPoint p) {
		if (p.IsBig(getP2()) && p.IsSmall(getP1())) {
			return true;
		}
		return false;
	}



}
