package Multithreading;

/*
等待唤醒机制: 通过wait() 和 notify() 语句等待和唤醒线程

wait() , notify(),notifyAll()；
都使用在同步中，因为只要对持有监视器（锁）的线程操作。
所以要使用在同步中，因为只有同步才具有锁。

为什么这些操作线程的方法要定义在Object类中呢？
因为这些方法在操作同步中线程时，都必须要标识他们所操作线程只有的锁
只有同一个锁中的线程进行唤醒
也就是说，等待换和唤醒必须是同一个锁
而锁可以是任意对象，所以可以被任意对象调用的方法定义在Object类中的
 */

//代码优化
class Res{
    private String name;
    private String sex;
    private boolean flag;

    public Res(){
        flag = false; //代表一开始没有资源
    }

    public synchronized void  set(String name , String sex){
        if(this.flag) // 如果没有资源
        {
            try {
                this.wait(); //进程等待
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.name = name;
        this.sex = sex;
        this.flag = true; //表示现在已经存有资源
        this.notify(); //唤醒线程
    }
    public synchronized void get(){
        if(!this.flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(this.name+"::"+this.sex);
        this.flag = false;
        this.notify();
    }
}


class Input implements Runnable{
    Res r; // 共享资源 ,还可以利用单例设计模式实现

    public Input(Res r){
        this.r = r;
    }

    @Override
    public void run() {
        boolean flagb = true;

        while(true){
            //synchronized (r){ //这个对象必须是虚拟机内唯一的对象，可以是 InputOutput.class 这个类对象
                if(flagb){
                   r.set("Bob","male");
                    flagb = false;
                }
                else{
                    r.set("丽","女");
                    flagb = true;
                }
            }
        //}
    }
}

class Output implements Runnable{
    Res r; // 共享资源 ,还可以利用单例设计模式实现
    public Output(Res r){
        this.r = r;
    }
    @Override
    public void run() {
        while(true)
           // synchronized(r){ //两个线程的锁需要是一个锁，否则同步等于没用
                r.get();
        //}
    }
}

public class InputOutputDemo {
    public static void main(String[] args) {
        Res  r = new Res(); //共享资源

        new Thread(new Input(r)).start();
        new Thread(new Output(r)).start();

      /*  Input in = new Input(r);
        Output out = new Output(r);
        Thread t1 = new Thread(in);//用于输入的线程
        Thread t2 = new Thread(out); //用于输出的线程
        t1.start();
        t2.start();
       */

    }
}
