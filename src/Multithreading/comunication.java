package Multithreading;
/*
两个生产者两个消费者之间的进程通信，要求资源唯一，
并且生产一个资源，消费一个资源
（不能存在生产了同一个编号的资源，或者消费了同一个编号的资源）
 */


import java.security.PrivateKey;
import java.util.function.DoubleUnaryOperator;

class Resource{
    private String name;
    private int count = 1;//代表资源的编号
    private boolean flag = false;//资源锁，一个时间内只允许一个线程访问

    public synchronized void set(String name){
        //生产资源，如果有资源的话线程就冻结
        while(flag) { // 存有资源，冻结生产者线程
            // 如果时if(flag)的话，可能会导致连续两个生产者线程唤醒，生产出同一个编号的资源（因为第二个线程在此前已经判断过if了）
            try{
                this.wait();
            }
            catch (Exception e){
            }
        }
        this.name = name+"::"+count++;
        System.out.println(Thread.currentThread().getName()+"生产者："+this.name);
        flag = true;//表示已经生产了资源，需要先被消耗掉才能继续生产
        this.notifyAll(); // 唤醒所有线程（如果时notify()的话可能会导致死锁）
    }

    public synchronized void out(){
        while(!flag){ // 如果没有资源，需要冻结消费者线程
            try{
                this.wait();
            }
            catch (Exception e){

            }
        }
        System.out.println(Thread.currentThread().getName()+"消费者："+this.name);
        flag = false;// 表示已经消费完资源
        this.notifyAll();
    }
}

class Producer implements Runnable{
    private Resource res;
    public Producer(Resource res){
        this.res = res;
    }
    @Override
    public void run() {
        while(true){
            res.set("商品+");
        }
    }
}


class Consumer implements Runnable{
    private Resource res;
    public Consumer(Resource res){
        this.res = res;
    }
    @Override
    public void run() {
        while(true){
            res.out();
        }
    }
}



public class comunication {
    public static void main(String[] args) {
        Resource r = new Resource();
        new Thread(new Producer(r)).start();
        new Thread(new Producer(r)).start();
        new Thread(new Consumer(r)).start();
        new Thread(new Consumer(r)).start();
    }
}
