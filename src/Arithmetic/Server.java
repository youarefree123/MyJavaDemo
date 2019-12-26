package Arithmetic;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 计算器服务器端
 */
public class Server {

    private  ServerSocket serverSocket;

    public Server(){
        try {
            this.serverSocket = new ServerSocket(9700); //监听5678端口
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public static void main(String[] args) {
        try {
            Server server = new Server();
            while(true){
                Socket client = server.getServerSocket().accept(); //接收客户端请求
                System.out.println(server.getServerSocket().getInetAddress() ); //打印客户端的地址
                InputStream in= client.getInputStream(); //接收客户端传来的数据流
                ObjectInputStream ois=new ObjectInputStream(in); //重构对象
                Object o = ois.readObject(); //读取
                Calculations ca = (Calculations) o; //计算
                if(ca.getWay().equals("end"))
                    break;
                int result = Calculation(ca.getWay(),ca.getValue1(),ca.getValue2());

                OutputStream os=client.getOutputStream();
                DataOutputStream dos=new DataOutputStream(os);
                dos.writeInt(result);
                dos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static int Calculation(String way , int a , int b ){
        Calculate cal = new Calculate();
        if("+".equals(way)){
            return cal.plus(a, b);
        }else if("-".equals(way)){
            return cal.minus(a, b);
        }else if("*".equals(way)){
            return cal.mul(a, b);
        }else if("/".equals(way)){
            return cal.Divide(a, b);
        }else{
            return 63353;
        }
    }


}