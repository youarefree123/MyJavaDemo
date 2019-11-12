package Generic;

import java.util.ArrayList;
import java.util.List;

class Animal {
    public Animal(){
        System.out.println("我是动物");
    }
}

class Dog extends Animal {
    public Dog(){
        System.out.println("我是狗");
    }
}




public class Test1 {

/*
//定义带类型参数的方法，其主要目的是为了表达多个参数
//以及返回值之间的关系。例如本例子中T和S的继承关系，
//返回值的类型和第一个类型参数的值相同。

    public<T, S extends T> T testDemo(T t, S s){
        System.out.println("我是 T 类型，我的类型是" + t.getClass().getName());
        System.out.println("我是 S 类型，我的类型是" + s.getClass().getName());
        return t;
    }

 */

//使用通配符解决
public void testDemo(List<?> s){
    for(Object ojb : s)
        System.out.println("我的类型是："+ojb.getClass().getName());
}

    public static void main(String[] args) {
        Test1 test = new Test1();
        Dog a0 = new Dog();
        Animal a1 = new Animal();
        List<Animal> s  = new ArrayList<Animal>();
        s.add(a0);
        s.add(a1);
        test.testDemo(s);
    }


}
