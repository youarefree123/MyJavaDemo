package Arithmetic;


import java.io.Serializable;

//public class CalculationPoj implements Serializable{

/**
 * 计算器类
 */

public class Calculations implements Serializable {
    public String way;
    public int value1;
    public int value2;


    public Calculations(String way, int value1 , int value2){
        this.way = way;
        this.value1 = value1;
        this.value2 = value2;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }

}