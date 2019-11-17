/*
 * 创建图形化界面
 * 1：创建Frame窗体
 * 2：对窗体进行设置：大小，位置，布局
 * 3：定义组件
 * 4:将组件通过窗体的add方法添加到窗体中
 * 5：让窗体显示，通过setVisible(true);
 */



package GUI;
import java.awt.*;
public class AwtDemo {
    public static void main(String[] args) {
        Frame f = new Frame("my awt");
        f.setSize(500,500); //设置窗体初始大小
        f.setLocation(300,200);//设置窗体距屏幕最左端位置
        f.setLayout(new FlowLayout());
        Button b = new Button("app");
        f.add(b);

        f.setVisible(true); //设置窗体可见
       // System.out.println("Hello World");
    }
}
