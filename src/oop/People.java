package oop;

//public class People {
//    //属性（成员变量） 有什么
//    double height;  //身高
//    int age;     //年龄
//    int sex;    //性别，0为男性，非0为女性
//
//    //方法 干什么
//    void cry(){
//        System.out.println("我在哭！");
//    }
//    void laugh(){
//        System.out.println("我在笑！");
//    }
//    void printBaseMes(){
//        System.out.println("我的身高是"+height+"cm");
//        System.out.println("我的年龄是"+age+"岁");
//        if(this.sex==0)
//            System.out.println("我是男性！");
//        else
//            System.out.println("我是女性！");
//    }
//}

//
//public class People {
//    //属性（成员变量）有什么，前面添加了访问修饰符private
////变成了私有属性，必须通过方法调用
//    private double height;     //身高
//
//    //属性已经封装好了，如果用户需要调用属性
////必须用getter和setter方法进行调用
////getter和setter方法需要程序员自己定义
//    public double getHeight(){
//        //getter 方法命名是get关键字加属性名（属性名首字母大写）
//        //getter 方法一般是为了得到属性值
//        return height;
//    }
//
//    //同理设置我们的setter方法
////setter 方法命名是set关键字加属性名（首字母大写）
////setter 方法一般是给属性值赋值，所以有一个参数
//    public void setHeight(double newHeight){
//        height = newHeight;
//    }
//}

//// People.java
////外部类People
//public class People {
//    private String name = "LiLei";         //外部类的私有属性
//    //内部类Student
//    public class Student {
//        String ID = "20151234";               //内部类的成员属性
//        //内部类的方法
//        public void stuInfo(){
//            System.out.println("访问外部类中的name：" + name);
//            System.out.println("访问内部类中的ID：" + ID);
//        }
//    }
//
//    //测试成员内部类
//    public static void main(String[] args) {
//        People a = new People();     //创建外部类对象，对象名为a
//        Student b = a.new Student(); //使用外部类对象创建内部类对象，对象名为b
//        // 或者为 People.Student b = a.new Student();
//        b.stuInfo();   //调用内部对象的suInfo方法
//    }
//}
////注：成员内部类不能含有 static 的变量和方法，
//// 因为成员内部类需要先创建了外部类，才能创建
//// 它自己的。

//// People.java
////外部类People
//public class People {
//    private String name = "LiLei";         //外部类的私有属性
//
//    /*外部类的静态变量。
//    Java 中被 static 修饰的成员称为静态成员或类成员。
//    它属于整个类所有，而不是某个对象所有，即被类的所
//    有对象所共享。静态成员可以使用类名直接访问，也可
//    以使用对象名进行访问。
//    */
//    static String ID = "510xxx199X0724XXXX";
//
//    //静态内部类Student
//    public static class Student {
//        String ID = "20151234";               //内部类的成员属性
//        //内部类的方法
//        public void stuInfo(){
//            System.out.println("访问外部类中的name：" + (new People().name));
//            System.out.println("访问外部类中的ID：" + People.ID);
//            System.out.println("访问内部类中的ID：" + ID);
//        }
//    }
//
//    //测试成员内部类
//    public static void main(String[] args) {
//        Student b = new Student();   //直接创建内部类对象，对象名为b
//        b.stuInfo();                 //调用内部对象的suInfo方法
//    }
//}





