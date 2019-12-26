package Homework.network;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class URLDemo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.chizhouyu.com/");
        URLConnection con = url.openConnection();
        con.connect(); //与服务器建立套接字连接
        System.out.println(con.getHeaderField("Pass_code"));



//        Map<String, List<String>> header = con.getHeaderFields();
//        for(Map.Entry<String, List<String>> entry : header.entrySet())
//        {
//            String key = entry.getKey();
//            for(String val:entry.getValue())
//                System.out.println(key+":"+val);
//        }
    }
}
