package IOStream;

/*
创建一个FileWirter对象，该对象一被初始化就必须要明确被操作的文件
而且该文件会被创建到指定目录下，如果该目录上已经有同名文件，直接覆盖

flush() 刷新后可以继续使用
close() 刷新后直接关闭
 */
import java.io.*;

public class FileWirterDemo {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("demo.txt");
        fw.write("123"); //将字符串写到了流中
        fw.write("456"); //将字符串写到了流中
        // fw.flush(); //刷新流对象缓冲区的数据，刷到目的地中
        fw.close(); //关闭流资源，关闭前刷新一次流中的缓冲数据，将数据刷新到目的地中
    }
}
