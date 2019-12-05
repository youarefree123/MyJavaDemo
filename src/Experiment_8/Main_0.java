package Experiment_8;

import GUI.Robert;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.IOException;

import javax.swing.JFrame;

public class Main_0 {
	public static void main(String[] args) throws IOException {
		JFrame frame = new MouseFream();
//		drawingBoard db = new drawingBoard("ss.txt");
//		db.load();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE); //设置窗口关闭
		frame.setSize(800, 800);
		frame.setLocationRelativeTo(null); //窗口置于屏幕中间
		frame.setVisible(true); //设置窗口可见

		Robert rt = new Robert();
		frame.add(rt);

//		MouseFream mf = (MouseFream)frame;
//		if(!mf.getMainPanel().getSquares().isEmpty()){
//			System.out.println("-------");
//		}


		//EventQueue.invokeLater();
	}
}



//		public static void main(String[] args) {
//		EventQueue.invokeLater(() -> {
//			JFrame frame = new MouseFream();
//			frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
//			frame.setSize(800, 800);
//			frame.setLocationRelativeTo(null);
//			frame.setVisible(true);
//
//			Robert ro = new Robert();
//			frame.add(ro);
//
//
//		});
//	}
//}
//

