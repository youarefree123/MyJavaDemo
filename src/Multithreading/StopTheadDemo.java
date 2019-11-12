package Multithreading;

/*
如何停止线程？
方法只有一种，run方法结束
只要控制住多线程运行，就可以让run方法结束，也就是线程结束

特殊情况：
当线程处于了冻结状态(中断状态)，
就不会读取到标记，那么线程就不会结束
当没有指定方式让中断的线程回复到运行状态时，需要对该类线程进行清除
解决方法：利用interrupt()方法强制唤醒线程.使线程进入运行态
interrupt() 中断线程

后台线程：当所有前台线程都结束后，后台线程会自动结束
守护线程：setDaemon()
join(): 等待该线程终止
 */

import com.sun.jdi.ThreadReference;
import javafx.scene.paint.Stop;

class StopThread implements Runnable {
    private boolean flag = true;

    @Override
    public void run() {
        while (flag) {
            System.out.println(Thread.currentThread().getName() + "------run");
        }
    }
    public void changeFlag(){
        flag = !flag;
    }
}


public class StopTheadDemo {
    public static void main(String[] args) {
        StopThread st = new StopThread();
        new Thread(st).start();
        new Thread(st).start();
        int num = 0 ;
        while(true){
            if(num++ == 6000){
                st.changeFlag();
                break;
            }
            System.out.println(Thread.currentThread().getName()+num);
        }
    }
}
