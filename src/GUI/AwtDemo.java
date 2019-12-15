/*
 * 创建图形化界面
 * 1：创建Frame窗体
 * 2：对窗体进行设置：大小，位置，布局
 * 3：定义组件
 * 4:将组件通过窗体的add方法添加到窗体中
 * 5：让窗体显示，通过setVisible(true);
 */

/*
事件监听机制的特点
1：事件源
2：事件
3：监听器
3：事件处理
事件源;就是awt包或者swing包中的那些图形界面组件
事件：每一个事件源都有自己特有的对应事件和共性事件
监听器：将可以触发某个事件的动作都已经封装到监听器中

对产生的动作进行处理
 */

package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AwtDemo {
    public static void main(String[] args) {
        Frame f = new Frame("my awt");
        f.setSize(500,500); //设置窗体初始大小
        f.setLocation(300,200);//设置窗体距屏幕最左端位置
        f.setLayout(new FlowLayout());
        Button b = new Button("button");
        f.add(b);
//        f.addWindowListener(new Mywin());
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.out.println("我关了");
                System.exit(0);
            }

            @Override
            public void windowActivated(WindowEvent windowEvent) {
                System.out.println("我活了");
            }

            @Override
            public void windowOpened(WindowEvent windowEvent) {
                System.out.println("我被打开了");
            }
        });
        f.setVisible(true); //设置窗体可见f
       // System.out.println("Hello World");
    }
}

//class Mywin extends WindowAdapter{
//    @Override
//    public void windowClosing(WindowEvent windowEvent) {
//        System.out.println("我关了");
//        System.out.println(windowEvent.toString());
//        System.exit(0);
//    }
//}