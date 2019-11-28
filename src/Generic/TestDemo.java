package Generic;


import java.util.TreeSet;

class Test<T>{
    private T ob;
     /*
    定义泛型成员变量，定义完类型参数后，可以在定义位置
    之后的方法的任意地方使用类型参数，就像使用普通的类型
    一样。
    注意，父类定义的类型参数不能被子类继承。
    */

     //构造函数
    public Test(T ob){
        this.ob = ob;
    }
    public Test(){}

    //getter 方法
    public T getOb(){
        return ob;
    }

    //setter 方法
    public void setOb(T ob){
        this.ob = ob;
    }

    public void showType(){
        System.out.println("T的实际类型是："+ob.getClass().getName());
    }
}



public class TestDemo {
    public static void main(String[] args) {
        // 定义泛型类 Main_0 的一个Integer版本
        Test<Integer> intOb = new Test<Integer>(88);
        intOb.showType();
        int i = intOb.getOb();
        System.out.println("value = "+ i);
        intOb.setOb(1024);
        System.out.println("now value = "+ intOb.getOb());
        System.out.println("-------------------------------");
        // 定义泛型类Test的一个String版本
        Test<String> strOb = new Test<String>("Hello World");
        strOb.showType();
        String s = strOb.getOb();
        System.out.println("value= " + s);
    }
}











