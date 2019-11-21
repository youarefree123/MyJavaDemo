package Experiment_8;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MouseFream extends JFrame {
	public MouseFream() {
		MouseComponent mainPanel = new MouseComponent();
		add(mainPanel);
		JButton colorbtn = new JButton();
		colorbtn.setPreferredSize(new Dimension(20, 20));
		colorbtn.setBackground(Color.BLACK);

		JButton blue = new JButton("blue");
		blue.addActionListener(ActionEvent -> {
			mainPanel.setPenColor(Color.BLUE);
			colorbtn.setBackground(Color.BLUE);
		});
		JButton green = new JButton("green");
		green.addActionListener(ActionEvent -> {
			mainPanel.setPenColor(Color.GREEN);
			colorbtn.setBackground(Color.GREEN);
		});
		JButton red = new JButton("red");
		red.addActionListener(ActionEvent -> {
			mainPanel.setPenColor(Color.RED);
			colorbtn.setBackground(Color.RED);
		});
		JButton pink = new JButton("pink");
		pink.addActionListener(ActionEvent -> {
			mainPanel.setPenColor(Color.PINK);
			colorbtn.setBackground(Color.PINK);
		});
		colorbtn.setOpaque(true);
		colorbtn.setBorderPainted(false);
		JPanel colorpanel = new JPanel();
		colorpanel.add(blue);
		colorpanel.add(red);
		colorpanel.add(green);
		colorpanel.add(pink);
		colorpanel.add(colorbtn);
		add(colorpanel, BorderLayout.NORTH);
		JButton rect = new JButton("rect");
		rect.addActionListener(ActionEvent -> {
			mainPanel.setShapetype("rect");
		});
		JButton elli = new JButton("elli");
		elli.addActionListener(ActionEvent -> {
			mainPanel.setShapetype("elli");
		});
		JPanel colorpanel2 = new JPanel();
		colorpanel2.add(rect);
		colorpanel2.add(elli);
		add(colorpanel2, BorderLayout.SOUTH);

	}
}
