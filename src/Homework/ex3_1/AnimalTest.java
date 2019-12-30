package Homework.ex3_1;

/**
 * 实验三：类与对象
 */
class Food{ //食物类
    private String name;
    public Food(String name){ this.name = name; }
    public String getName(){ return name; }
}
class Animals{ //动物类
    private String name;
    public Animals(String name) { this.name = name; }
    public void eat( Food  f){ System.out.println(name+"吃"+f.getName()); }
    public String getName(){ return name; }
}
class Breeder{ //饲养员类
    private String name;
    public Breeder(String name) { this.name = name; }
    public void feed(String an){ System.out.println(name+"喂"+an); }
}
public class AnimalTest {
    public static void main(String[] args) {
        Animals panda = new Animals("大熊猫");
        Animals bear = new Animals("大熊");
        Food bamboo = new Food("竹笋");
        Breeder zs = new Breeder("张三");
        zs.feed(bear.getName());
        panda.eat(bamboo);
    }
}
