package Aberrant;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowTest {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = null;
        //当a或者b为null时，抛出异常
        if(a == null || b == null){
            throw new NullPointerException();
        }else{
            System.out.println(a+b);
        }
}

//        public static void main(String[] args) throws FileNotFoundException{
//            //由方法的调用者捕获异常或者继续向上抛出
//            throwsTest();
//
//        }
//
//        public static void throwsTest() throws FileNotFoundException{
//            new FileInputStream("/home/project/shiyanlou.file");
//        }


    }

