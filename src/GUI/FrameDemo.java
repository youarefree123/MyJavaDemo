package GUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;

public class FrameDemo {
    //定义该图形中所需的组件的引用
    private Frame f;
    private Button but;

    public FrameDemo(){
       this.init();
    }
    public void init(){
        f = new Frame("my frame");
        //对frame进行基本设置
        f.setBounds(300,100,600,500);//x,y,width,height
        f.setLayout(new FlowLayout());
        but = new Button("My button");
        f.add(but);
        myEvent(); //加载窗体事件
        f.setVisible(true);
    }

    private void myEvent(){
//        f.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent windowEvent) {
//                System.exit(0);
//            }
//        });

        //让按钮具备退出程序的功能
        //选择addActionListener() :没有适配器
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("是按钮干的");
                System.exit(0);
            }
        });
    }


    public static void main(String[] args) {
        new FrameDemo();
    }

}
