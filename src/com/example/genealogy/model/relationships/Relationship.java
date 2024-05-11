package com.example.genealogy.model.relationships;

import com.example.genealogy.model.Person;

public class Relationship {

    private Person person1;
    private Person person2;
    private String type;

    public Relationship(Person person1, Person person2, String type) {
        this.person1 = person1;
        this.person2 = person2;
        this.type = type;
    }

    public Person getPerson1() {
        return person1;
    }

    public Person getPerson2() {
        return person2;
    }

    public String getType() {
        return type;
    }
}
