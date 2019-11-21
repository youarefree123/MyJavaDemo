package IOStream;


import java.io.FileWriter;
import java.io.IOException;

/*
IO异常的处理方式
 */
public class FileWirterDemo2 {
    public static void main(String[] args) {
        FileWriter fw = null; //定义一个空对象
        try {
            fw = new FileWriter("demo.txt");//对象初始化
            fw.write("123");
        }
        catch (IOException e){
            System.out.println("catch:"+e.toString());
        }
        finally {
            try{
                if (fw != null) //只有当fw不为空的时候才能进行关操作
                    fw.close(); //close方法会调用flush刷新
            }
            catch (IOException e){
                System.out.println(e.toString());
            }
        }
    }
}
