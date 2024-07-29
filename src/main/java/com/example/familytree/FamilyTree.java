package com.example.familytree;

import java.util.HashMap;
import java.util.Map;

public class FamilyTree {
    private Map<String, Person> people;

    public FamilyTree() {
        people = new HashMap<>();
    }

    public void addPerson(String name) {
        people.put(name, new Person(name));
    }

    public void addChild(String parentName, String childName) {
        Person parent = people.get(parentName);
        Person child = new Person(childName);
        if (parent != null) {
            parent.addChild(child);
            people.put(childName, child);
        }
    }

    public Person getPerson(String name) {
        return people.get(name);
    }

    public void printFamilyTree() {
        for (Person person : people.values()) {
            System.out.println(person);
        }
    }
}
