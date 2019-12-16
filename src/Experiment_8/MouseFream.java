package Experiment_8;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;


import javax.swing.*;


public class MouseFream extends JFrame { // 布局
	private MouseComponent mainPanel;
	public MouseFream() {
		mainPanel = new MouseComponent(); //主面板
		add(mainPanel);
		JButton colorbut = new JButton(); //新建一个按钮
		colorbut.setPreferredSize(new Dimension(20, 20)); //设置按钮大小
		colorbut.setBackground(Color.BLUE); //设置按钮的颜色

		JButton blue = new JButton("blue");
		blue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				mainPanel.setPenColor(Color.BLUE);
				colorbut.setBackground(Color.BLUE);
			}
		});

		JButton black = new JButton("black");
		black.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				mainPanel.setPenColor(Color.BLACK);
				colorbut.setBackground(Color.BLACK);
			}
		});

		JButton green = new JButton("green");
		green.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				mainPanel.setPenColor(Color.GREEN);
				colorbut.setBackground(Color.GREEN);
			}
		});

		JButton red = new JButton("red");
		red.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				mainPanel.setPenColor(Color.RED);
				colorbut.setBackground(Color.RED);
			}
		});

		JButton pink = new JButton("pink");
		pink.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				mainPanel.setPenColor(Color.PINK);
				colorbut.setBackground(Color.PINK);
			}
		});


		colorbut.setOpaque(true); //设置组件不透明(右上角)
		colorbut.setBorderPainted(false); //去边框
		JPanel colorpanel = new JPanel();
		colorpanel.add(blue);
		colorpanel.add(red);
		colorpanel.add(green);
		colorpanel.add(pink);
		colorpanel.add(black);
		colorpanel.add(colorbut);  //添加这五个容器
		add(colorpanel, BorderLayout.NORTH); //边框布局(北)

		JButton rectangle = new JButton("rectangle");
		rectangle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainPanel.setShapetype("rectangle");
            }
        });

		JButton ellipse = new JButton("ellipse");
		ellipse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mainPanel.setShapetype("ellipse");
            }
        });

		JPanel colorpanel2 = new JPanel();
		colorpanel2.add(rectangle);
		colorpanel2.add(ellipse);
		add(colorpanel2, BorderLayout.SOUTH); //边框布局(南)

	}

	public MouseComponent getMainPanel() {
		return mainPanel;
	}
}
