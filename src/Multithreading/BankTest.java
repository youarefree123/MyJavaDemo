package Multithreading;

/*
需求：银行有一个金库
有两个储户分别存300元，每次存100，每个储户存三次
目的：该程序是否有安全问题，如果有，如何解决

如何找问题：
1：明确那些代码是多线程运行代码。
2：明确共享数据
3：明确多线程运行代码中哪些语句是操作共享数据的
 */

class Bank{
    private int sum;
    // Object obj = new Object(); //要放到方法外
    //两种实现方法，一种是添加代码块synchronized,另一种是直接在该函数上添加该关键字

public synchronized void add(int n){
    sum = sum+n;
    try{Thread.sleep(10);}catch (Exception e){}
    System.out.println(sum);
}


//    public void add(int n){
//        synchronized(obj){ //传入的对象相当于OS中的一个锁
//            sum = sum + n;
//            try {Thread.sleep(10);} catch (Exception e){}//延迟十毫秒
//            System.out.println(sum);
//        }
//    }
}

class Cus implements Runnable{ //实现Runnable接口相当于实现了一个线程
    private Bank b = new Bank(); //共享资源

    @Override
    public void run() {
        for (int x = 0 ; x < 3 ; ++x){
            b.add(100);
        }
    }
}



public class BankTest {
    public static void main(String[] args) {
        Cus c1 = new Cus();
        Thread n1 = new Thread(c1);
        Thread n2 = new Thread(c1);
        n1.start();
        n2.start();


    }
}
