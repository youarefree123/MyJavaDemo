package Homework;

public class Teacher {
    //属性
    private String name; // 姓名
    private String sex; //性别
    private int age; //年龄
    private String course; //讲授课程

    //方法
    public Teacher() {
    }
    public Teacher(String name, String sex, int age, String course) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.course = course;
    }
    public String getCourse(){
        return course;
    }

    public void setCourse(String course) {
        try {
            this.course = course;
            System.out.println("True");
        }
        catch (ClassCastException e){
            System.out.println("False");
        }

    }

    public void getDetails() {
        System.out.println("name = "+name);
        System.out.println("sex = "+sex);
        System.out.println("age = "+age);
        System.out.println("course = "+course);

    }

    public static void main(String[] args) {
        Teacher zs = new Teacher("张三","男",28,"数学");
        System.out.println(zs.getCourse());
        zs.setCourse("语文");
        zs.getDetails();
    }


}
