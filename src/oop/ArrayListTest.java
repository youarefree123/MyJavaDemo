package oop;
import java.util.*;
public class ArrayListTest {
    public static void main(String[] args) {
        ArrayList<String> staff = new ArrayList<>();
        staff.add("12");
        staff.add("sciu");
        staff.add("csbiaub");

        for(String iterator : staff){
            System.out.println(iterator.length());
        }
        String ss = staff.get(1);
        System.out.println(ss);
    }
}
