package Multithreading;

/*
多线程的单例设计模式，分为饿汉式和懒汉式
懒汉式和饿汉式的区别式懒汉式可以延迟加载
但是在多线程情况下，懒汉式会出现线程安全问题，所以
需要加锁，如果每个线程都需要判断锁会导致效率低下
所以可以在外面再套一层循环
 */

//饿汉式

//class Single{
//    private static final Single s = new Single();
//    public static Single getInstance() {
//        return s;
//    }
//}




//懒汉式
class Single {
    private static Single s = null;

    private Single() {
    }
    public static Single getInstance(Single s) {
        if (s == null) {
            synchronized (SingleDesign.class) {
                if (s == null) {
                    s = new Single();
                }
            }
        }
        return s;
    }
}




public class SingleDesign {
}
