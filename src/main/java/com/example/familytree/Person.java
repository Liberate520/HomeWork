package com.example.familytree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private List<Person> children;

    public Person(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public List<Person> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', children=" + children + '}';
    }
}
