package Homework;
public class foreach1 {

    public static void main(String[] argv)
    {
        int[] aArray = new int[3];
        for(int i = 0; i < 3; i++)
        {
            aArray[i] = i;
        }
        for(int element:aArray)
        {
            System.out.println("before:"+element);//查看数组中的元素
        }
        for(int element:aArray)
        {
            element += 10;; //试图通过element改变数组中的元素值
            System.out.println("try to modify to :"+element);
        }
        for(int element:aArray)
        {
            System.out.println("after:"+element);//查看是否改变成功
        }
        People[] ps = new People[3];  //放在堆中的可以修改？？
        ps[0] = new People();
        ps[1] = new People();
        ps[2] = new People();
        System.out.println("before:");
        for(People element:ps)
        {
            System.out.println(element);//打印原来数组中的元素
        }
        System.out.println("modify:");
        for(People element:ps)
        {
            element.name = "hanghang";
            element.age = 2;
            System.out.println(element);//试图去改变元素的值
        }
        System.out.println("after:");
        for(People element:ps)
        {
            System.out.println(element);//查看是否改变成功
        }
    }
}

class People {
    public String name;
    public int age;
    public People()
    {
        name = "xiaomin";
        age = 10;
    }
    @Override
    public String toString() {
        return "People [name=" + name + ", age=" + age + "]";
    }

}