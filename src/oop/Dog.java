package oop;

public class Dog extends Animal {
    //类方法重写
    public void bark(){
        System.out.println("汪汪汪");
    }
}

//因此，向上转型，在运行时，会遗忘子类对象
// 中与父类对象中不同的方法，也会覆盖与父类
// 中相同的方法——重写。（方法名，参数都相同）

class Test11 {
    public static void main(String[] args) {
        Dog  a = new Dog();
        Animal b = new Dog(); // Dog 对象,向上转型为Animal类型
        a.legNum = 4;
        a.bark();
        b.bark();
    }
}