package IOStream;


import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args)throws IOException {
        //创建一个文件读取流对象，和指定名称的文件相关联
        //要保证该文件是否已经存在，如果不存在，会发生FileNotFoundException异常
        FileReader fr = new FileReader("demo.txt");

        //调用读取流对象的read方法.
        //read方法，一次读一个字符，并且会一直往下读
        //int ch = fr.read();

        int ch;
        while((ch = fr.read())!= -1)
            System.out.println((char)ch);

    }
}
