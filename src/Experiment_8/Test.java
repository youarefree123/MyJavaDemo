package Experiment_8;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Test {

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			JFrame frame = new MouseFream();
			frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
			frame.setSize(800, 800);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);

		});
	}

//	public static void main(String[] args) {
//		JFrame frame = new MouseFream();
//		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
//		frame.setSize(800, 800);
//		frame.setLocationRelativeTo(null);
//		frame.setVisible(true);
//		EventQueue.invokeLater();
//	}

}
