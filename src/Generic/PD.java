package Generic;

import java.util.HashSet;
import java.util.Set;

public class PD {
    public String id;
    public String name;
    //集合后面的<>代表泛型的意思
    //泛型是规定了集合元素的类型
    public Set<Student> students;

    public PD(String id, String name){
        this.id = id;
        this.name = name;
        this.students = new HashSet<Student>();
    }
}
