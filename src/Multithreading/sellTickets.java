package Multithreading;

/*
需求： 简单的卖票程序
多个窗口同时卖票

创建的第二种方法：
1：定义类实现Runnable接口
2：通过Thread类建立线程对象
3：将Runnable接口的子类对象作为实际参数传递给Thread的构造函数
4：调用Thread类的start方法开启线程并调用Runnable接口子类的run方法


实现方式和继承方式的区别：java是单继承 ， 如果继承了一个父类，就无法继承Thread类
好处在于避免了单继承的局限性在定义线程时建议使用接口方式


两种方式区别：存放代码的地方不同
 */

/*
多线程问题会出现安全问题：（比如出现卖出来负票）
产生原因：当多条语句在操作同一个线程共享数据时，一个线程
        对多条语句值执行了一部分，还没有执行完，就被冻结
        另一个线程参与进来 ，导致共享数据的错误。
解决办法：对多个操作共享数据的语句，只能某一个时间段让一个线程
           执行完，并且执行过程中，其他线程不参与执行。
java提供同步代码块这种专业的解决方式，用于解决这种安全问题

将需要同步的代码块放入下面
synchronized(对象){ 翻译：已同步
    需要被同步的代码
}

对象可以当作一把锁，持有锁的对象可以执行
没有锁即使获取cpu的执行权也执行不了代码块内的代码

同步的前提：1：必须要有两个及两个以上的线程（否则同步操作没必要）
            2：必须是多个线程使用同一个锁
            必须保证只有 一个线程在运行
 好处：解决了多线程的安全问题
 弊端:多个线程需要判断所，消耗资源

 */


class Ticket implements Runnable {//extends Thread //卖票线程
    private int number = 100; //总共有100张票
    Object obj = new Object();

    @Override
    public void run() {
        while(true){
            synchronized (obj){  //放入需要同步的代码块
                if(number > 0){
                    try {
                        Thread.sleep(10); //进程延时10ms
                    }
                    catch (Exception e){}
                    System.out.println(Thread.currentThread().getName()+":"+number--);
                }
            }
        }
    }
}

public class sellTickets {
    public static void main(String[] args) {
        Ticket t1 = new Ticket(); //一个实现了Runnable接口的类

        Thread n1 = new Thread(t1);
        Thread n2 = new Thread(t1);
        Thread n3 = new Thread(t1);
        n1.start();
        n2.start();
        n3.start();

    }
}
