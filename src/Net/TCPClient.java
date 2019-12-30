package Net;
/*
1:TCP分客户端和服务端
2：客户端对应的对象是Socket
   服务器对应的对象是ServerSocket
 */

/*
客户端：在建立Socket服务时，就要和服务端连接
需求，给服务器发送数据
步骤：
1：创建Socket服务并指定IP和端口
2:或企业连接过来的客户端对象
通过ServerSorcket的accept方法，没有连接就会等地，所以这个方法是阻塞式的
3：客户端发送数据过来，服务端就使用对应的客户端对象，获得输入输出流。
4：关闭服务端（可选）
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;


import static java.net.InetAddress.*;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket(getLocalHost(),10003);
//        Socket server =  new Socket(InetAddress.getLocalHost(),9700);
        //获取Socket流中的输出流
        OutputStream out = s.getOutputStream();
        out.write("tcp ge".getBytes());
        //获取Socket流中的输入流，将服务端反馈给数据获取到，并打印
        InputStream in = s.getInputStream();
        byte[] buf = new byte[1024];
        int len = in.read(buf);
        System.out.println(new String(buf,0,len));
        s.close();
    }
}
