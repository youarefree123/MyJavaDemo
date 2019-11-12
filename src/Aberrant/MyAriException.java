package Aberrant;

public class MyAriException extends ArithmeticException {

//自定义异常类，该类继承自ArithmeticException
public  MyAriException(){}
//无参构造方法

    public MyAriException(String msg){
    super(msg);
        //实现可以自定义输出信息的构造方法，将待输出信息作为参数传入即可

    }



}
