package com.example.genealogy.model;

import java.time.LocalDate;

public class Person {

    private String name;
    private LocalDate dateOfBirth;
    private Person parent;

    public Person(String name, Person parent) {
        this.name = name;
        this.dateOfBirth = LocalDate.now();
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Person getParent() {
        return parent;
    }

}