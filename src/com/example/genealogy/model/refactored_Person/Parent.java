package com.example.genealogy.model.refactored_Person;
import java.util.ArrayList;
import java.util.List;

public class Parent {

    private Person person;
    private List<IPerson> children;

    public Parent(String name) {
        this.person = new Person(name);
        this.children = new ArrayList<>();
    }

    public String getName() {
        return person.getName();
    }

    public void addChild(IPerson child) {
        children.add(child);
    }

    public List<IPerson> getChildren() {
        return children;
    }

}
