package Multithreading;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
两个生产者两个消费者之间的进程通信，要求资源唯一，
并且生产一个资源，消费一个资源
（不能存在生产了同一个编号的资源，或者消费了同一个编号的资源）

JDK 1.5 提供的新的同步解决方案
Lock类替代了Synchronized 代码块的作用，使代码同步化， Lock下的Confition类替代了awit()和notify()
 */




class Resource2{
    private String name;
    private int count = 1;//代表资源的编号
    private boolean flag = false;//资源锁，一个时间内只允许一个线程访问
    private Lock lock = new ReentrantLock();
    private Condition con1 = lock.newCondition(); //生产者
    private Condition con2 = lock.newCondition(); //消费者




    public synchronized void set(String name)throws InterruptedException{
        //生产资源，如果有资源的话线程就冻结
        lock.lock();
        while(flag) { // 存有资源，冻结生产者线程
            // 如果时if(flag)的话，可能会导致连续两个生产者线程唤醒，生产出同一个编号的资源（因为第二个线程在此前已经判断过if了）
            try{
                con1.await(); //生产者等待
            }finally {
                lock.unlock(); //解锁操作必须执行
            }

        }
        this.name = name+"::"+count++;
        System.out.println(Thread.currentThread().getName()+"生产者："+this.name);
        flag = true;//表示已经生产了资源，需要先被消耗掉才能继续生产
        con2.signal();//唤醒消费者线程
    }

    public synchronized void out()throws InterruptedException{
        lock.lock();//先上锁
        while(!flag){ // 如果没有资源，需要冻结消费者线程
            try{
                con2.await();//消费者冻结（或者叫循环等待?）
            }finally {
                lock.unlock();//最终解锁
            }
        }
        System.out.println(Thread.currentThread().getName()+"消费者："+this.name);
        flag = false;// 表示已经消费完资源
        con2.signal();//唤醒生产者线程
    }
}

class Producer2 implements Runnable{
    private Resource2 res;
    public Producer2(Resource2 res){
        this.res = res;
    }
    @Override
    public void run() {
        while(true){
            try {
                res.set("商品+");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class Consumer2 implements Runnable{
    private Resource2 res;
    public Consumer2(Resource2 res){
        this.res = res;
    }
    @Override
    public void run() {
        while(true){
            try {
                res.out();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class comunication2 {
    public static void main(String[] args) {
        Resource r = new Resource();
        new Thread(new Producer(r)).start();
        new Thread(new Producer(r)).start();
        new Thread(new Consumer(r)).start();
        new Thread(new Consumer(r)).start();
    }
}
