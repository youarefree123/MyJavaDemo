package GUI;

import Experiment_8.MouseComponent;

import java.awt.*;
import java.awt.event.*;

public class MouseAndEvent {
    private Frame f;
    private Button but;
    public MouseAndEvent(){
        this.init();
    }
    public void init(){ //初始化面板
        f = new Frame();
        f.setLayout(new FlowLayout()); //采用流式布局
        f.setBounds(100,300,550,600); //设置窗体大小
        f.setVisible(true); //设置窗体可见
        but = new Button("MyButton");
        f.add(but);//添加按钮
        MyEvent(); //添加事件监听
    }


    public void MyEvent(){
        //窗体监听器,关闭
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });


        //按钮的活动监听，鼠标键盘都可以让按钮产生事件
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.out.println("Active");
            }
        });


        //鼠标的鼠标事件，更具体一些
        but.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent mouseEvent) { //按住鼠标事件
                System.out.println("我移到了");
            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) { //松开鼠标事件
                System.out.println("我移开了");
            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {
                System.out.println("我松开了");
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                System.out.println("我按住了");
            }

            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                System.out.println("我点击了一次");
            }
        });
    }

    public static void main(String[] args) {
        new MouseAndEvent();
    }
}
