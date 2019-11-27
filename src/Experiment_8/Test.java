package Experiment_8;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Test {
	public static void main(String[] args) {
		JFrame frame = new MouseFream();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); //设置窗口关闭
		frame.setSize(800, 800);
		frame.setLocationRelativeTo(null); //窗口置于屏幕中间
		frame.setVisible(true); //设置窗口可见
		//EventQueue.invokeLater();
	}
}



	//	public static void main(String[] args) {
//		EventQueue.invokeLater(() -> {
//			JFrame frame = new MouseFream();
//			frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
//			frame.setSize(800, 800);
//			frame.setLocationRelativeTo(null);
//			frame.setVisible(true);
//
//		});
//	}
//}


