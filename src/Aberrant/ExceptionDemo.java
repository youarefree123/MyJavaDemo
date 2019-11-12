package Aberrant;

/*
毕老师用电脑上课

开始思考上课中的问题：
    电脑蓝屏
    电脑冒烟
对问题进行描述，并封装成对象

冒烟发生后，讲课进度无法继续
可是计划无法完成
 */

import java.security.MessageDigest;
import java.util.spi.LocaleNameProvider;

class LanPingException extends Exception{
    LanPingException(String message){
        super(message);
    }
}

class MaoYanException extends Exception{
    MaoYanException(String message){
        super(message);
    }
}

class NoPlanExcption extends Exception{
    NoPlanExcption(String message){
        super(message);
    }
}



class Computer{
    private int state = 1;

    public void run()throws LanPingException,MaoYanException
    {
        if(state == 1)
            throw new LanPingException("蓝屏了");
        if(state == 3)
            throw new MaoYanException("冒烟了");
        System.out.println("电脑运行");
    }

    public void reset(){
        state = 1;
        System.out.println("电脑重启");
    }
}



class Teacher {
    private String name;
    private Computer cmpt;

    Teacher(String name) {
        this.name = name;
        cmpt = new Computer();
    }

    public void prelect() throws NoPlanExcption {
        try {
            cmpt.run();
        } catch (MaoYanException e) {
            throw new NoPlanExcption("课时无法继续");
        } catch (LanPingException e) {
            System.out.println(e.toString());
            cmpt.reset();
        }
        System.out.println("讲课");
    }
}

public class ExceptionDemo {
    public static void main(String[] args) {
        Teacher t = new Teacher("毕老师");
       try{
           t.prelect();
       }
       catch (NoPlanExcption e){
           System.out.println("换老师上，或者放假");
       }

    }

}
