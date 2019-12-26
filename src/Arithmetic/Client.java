package Arithmetic;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.*;

//import com.boco.calculatorBySocket.CalculationPojo;
/**
 * 计算器客户端
 * @author Administrator
 *
 */
public class Client extends JFrame {
    private JPanel mainPanel; //面板
    private JLabel label; //标签
    private JComboBox ways ;//复选框


    public Client(){
        mainPanel = new JPanel(new FlowLayout()); //流式布局
       //文本框\复选框
        JTextField value1 = new JTextField(16); //文本框1
        String s[]={"+","-","*","/"};
        ways = new JComboBox(s); //复选框
        JTextField value2 = new JTextField(16); //文本框2
        mainPanel.add(value1);
        mainPanel.add(ways);
        mainPanel.add(value2);

        label = new JLabel("=");
        JTextField value3 = new JTextField(16); //文本框3
        mainPanel.add(label);
        mainPanel.add(value3);

        //按钮
        JPanel but = new JPanel(new FlowLayout());
        JButton bt1  = new JButton("确定"); //按钮
        JButton bt2  = new JButton("取消"); //按钮
        but.add(bt1);
        but.add(bt2);

        bt1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String v1=value1.getText();
                    String v2=value2.getText();
                    if(v2.equals("") && v1.equals("")){
                        return;
                    }
                    Socket server =  new Socket(InetAddress.getLocalHost(),9700);
//                    Socket server =  new Socket("192.168.1.105",9700);
                    String way = (String)ways.getSelectedItem();
                    OutputStream os = server.getOutputStream();

                    int item1 = Integer.parseInt(v1);
                    int item2 = Integer.parseInt(v2);
                    Calculations ca = new Calculations(way,item1,item2);
                    ObjectOutputStream out = new ObjectOutputStream(os); //重构类
                    out.writeObject(ca);
                    out.flush();
                    InputStream is = server.getInputStream();
                    DataInputStream dis = new DataInputStream(is);
                    int result= dis.readInt();
                    value3.setText(String.valueOf(result));

                    os.close();
                    out.close();
                    is.close();
                    dis.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

            }
        });
        bt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                value1.setText("");
                value2.setText("");
                value3.setText("");
            }
        });

        mainPanel.add(but); //添加按钮
        this.add(mainPanel);
    }


    public static void main (String[] args) {
        Client cc=new Client();
        cc.pack();
        cc.setVisible(true);
    }
}