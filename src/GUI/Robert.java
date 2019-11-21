package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

//@SuppressWarnings("serial")
public class Robert extends JComponent {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("机器人画图");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//程序运行结果生成一个窗体
        frame.setSize(800,800);
        //frame.setSize(y*2/3, x*2/3);
        frame.setLocationRelativeTo(null); //界面居中
        frame.setVisible(true); //显示界面
        Robert ro = new Robert();
        frame.add(ro); //继承自 Container 类
    }

    public void paintComponent(Graphics g){ //画组件
        Font fo = new Font("宋体", Font.BOLD, 50); //加粗宋体
        g.setFont(fo);
        g.drawString("我是机器人", 275, 750);
        Graphics2D g2 = (Graphics2D) g;					//转换g2为2D对象
        // 画身体
        Rectangle2D body = new Rectangle2D.Double(300, 150, 200, 300); //前两个是位置，后两个是大小
        g2.setColor(Color.RED);
        g2.fill(body); //涂满颜色
        g2.draw(body);
        //画头
        Ellipse2D head = new Ellipse2D.Double(330, 10, 140, 140);
        g2.setColor(Color.YELLOW);
        g2.fill(head);
        g2.draw(head);

        //画左臂
        Rectangle2D LArm = new Rectangle2D.Double(50, 150, 250, 40);
        g2.setColor(Color.GREEN);
        g2.fill(LArm);
        g2.draw(LArm);

        //画右臂
        Rectangle2D RArm = new Rectangle2D.Double(500, 150, 250, 40);
        g2.fill(RArm);
        g2.draw(RArm);

        //画左腿
        Rectangle2D LLeg = new Rectangle2D.Double(300, 450, 50, 250);
        g2.setColor(Color.BLACK);
        g2.fill(LLeg);
        g2.draw(LLeg);

        //画右腿
        Rectangle2D RLeg = new Rectangle2D.Double(450, 450, 50, 250);
        g2.draw(RLeg);
        g2.fill(RLeg);
    }
}