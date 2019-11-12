package Multithreading;

//线程拥有自己的name 通过getName()获得
//static Thread currentThread() ：获得当前线程对象 == this
class Test extends Thread{
    //重写run方法

    public Test(String name){
        super(name);
    }

    @Override
    public void run() {
        for(int i = 0 ; i < 60 ; ++i){
            System.out.println(this.getName()+":"+i+"-"+"testRun-");
        }
    }
}

public class TheadTest {
    public static void main(String[] args) {
        Test t1 =new Test("线程1"); //创建一个进程
        Test t2 = new Test("线程2");//创建第二个进程
        t1.start(); //启动进程（注意这里不能调用run方法，否则进程是没有开启的）
        t2.start();
    }

}
