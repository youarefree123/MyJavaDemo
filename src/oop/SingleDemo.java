package oop;

/*
设计模式 ：对问题行之有效的解决方式，是一种思想
1：单例设计模式：保证一个类再内存中的对象唯一性

实现互斥信息共享
保证对象唯一性：
1：允许其他程序用new创建该对象
2：在该类中创建一个本类实例
3：对外提供一个方法让其他程序可以获取该对象

步骤：
1：私有化该类的构造函数
2：通过new在本类中创建一个本类对象
3：定义一个共有的方法，将创建的对象返回
 */

import java.util.TreeSet;

class Single{
   private static Single s = new Single();
    private Single(){}
    public static Single getInstance(){
        return  s;
    }
    private int num ;
    public void setNum(int Num){
        this.num = Num;
    }
    public int getNum(){
        return num;
    }

}

/*
懒汉模式，只有调用方法时才会创建对象
单例设计模式的延迟加载形式
存在安全隐患！！！ 多线程操作时
 */
class Single2{
    private static Single2 s = null;
    private Single2(){}
    private static Single2 getInstance(){
        if (s == null)
            s = new Single2();
        return s;
    }
}






class Test{
     private Test(){}
     private static Test t = new Test();
     public static Test getInstance(){
         return t;
     }
     private int num ;
     public void setNum(int Num){
         this.num = Num;
     }
     public int getNum(){
         return num;
     }
}


public class SingleDemo {
    public static void main(String[] args) {

        Single s1 = Single.getInstance();
        Single s2 = Single.getInstance();
        System.out.println(s1 == s2);
        s1.setNum(4);
        System.out.println(s2.getNum());

    }

}
