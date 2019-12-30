package Net;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
/*
演示TCP的传输的客户端和服务端的互访
需求：客户端给服务端发送数据，服务端收到后，给客户端反馈信息
 */
public class TCPServer {
    public static void main(String[] args)throws IOException {
      //建立服务端服务，并监听一个端口
        ServerSocket ss = new ServerSocket(10003);
        //通过accept方法获取连接过来的客户端对象
        Socket s = ss.accept();
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip);
        //获取客户端发过来的数据，使用客户端对象的读取流来读数据
        InputStream in = s.getInputStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        System.out.println(new String(buf,0,len));
        OutputStream out = s.getOutputStream();
        out.write("copy that".getBytes());

        s.close(); //关闭客户端
//        ss.close();
    }
}
