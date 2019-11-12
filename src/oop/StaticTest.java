package oop;

public class StaticTest{
    public static String string="shiyanlou";
    public static void main(String[] args){
        //静态成员不需要实例化 直接就可以访问
        System.out.println(StaticTest.string);
        //如果不加static关键字 需要这样访问
        StaticTest staticTest=new StaticTest();
        System.out.println(staticTest.string);
        //如果加上static关键字，上面的两种方法都可以使用
    }

    /*
    静态方法不实例化也可以调用，所以不能有 this，
    也不能访问非静态成员变量和非静态方法。但是非
    静态成员变量和非静态方法可以访问静态方法。
     */
}