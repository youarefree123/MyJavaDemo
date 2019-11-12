package oop;

//抽象类
public abstract class TelePhone {
    public abstract void call();
    public abstract void message(); //发短信
}

class cellPhone extends TelePhone{
    @Override
    public void call() {
        System.out.println("打电话");
    }

    @Override
    public void message() {
        System.out.println("发短信");
    }

    public static void main(String[] args) {
        cellPhone cp = new cellPhone();
        cp.call();
        cp.message();
    }
}
