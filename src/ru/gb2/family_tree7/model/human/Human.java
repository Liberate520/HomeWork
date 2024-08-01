package ru.gb2.family_tree7.model.human;

import ru.gb2.family_tree7.model.group.GroupItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Comparable<Human>, GroupItem {
    private int id;
    private String name;
    private int age;

    public Human(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Human{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }
}