package com.example.genealogy.model.refactored_Person;

public class Child {

    private Person person;
    private Parent parent;

    public Child(String name, Parent parent) {
        this.person = new Person(name);
        this.parent = parent;
    }

    public String getName() {
        return person.getName();
    }

    public Parent getParent() {
        return parent;
    }

}
