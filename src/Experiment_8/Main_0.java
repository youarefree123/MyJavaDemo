package Experiment_8;

import GUI.Robert;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

import javax.swing.JFrame;

/**
 * 实验八：事件处理
 */
public class Main_0 {
	public static void main(String[] args){
		JFrame frame = new MouseFream();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); //设置窗口关闭
		frame.setSize(800, 800);
		frame.setLocationRelativeTo(null); //窗口置于屏幕中间
		frame.setVisible(true); //设置窗口可见

	}
}
