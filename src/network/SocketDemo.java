package network;

import java.io.*;
import java.net.Socket;


public class SocketDemo {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket ("www.chizhouyu.com",8817);
        System.out.println("远程主机地址：" + s.getRemoteSocketAddress());

        //获取Socket的输出流，用来发送数据到服务端
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        //获取Socket的输入流，用来接收从服务端发送过来的数据
        PrintStream out = new PrintStream(s.getOutputStream());

        String str = input.readLine();
        out.println(str);
        s.close();
    }
}
