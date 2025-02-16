package src;

import java.io.Serializable;




public class Human implements Serializable, Comparable<Human> {
    public Integer age;
    String name;
    gender sex;
    String lastName;
    Human father;
    Human mother;

    public Human(String name, Integer age, gender sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return name + " " + lastName + " " + age; 
    }

    @Override
    public int compareTo(Human o) {
        return this.age.compareTo(o.age);
    }
    
}
