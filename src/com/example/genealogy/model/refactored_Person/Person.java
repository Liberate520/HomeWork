package com.example.genealogy.model.refactored_Person;
import java.time.LocalDate;

public class Person implements IPerson {

    private String name;
    private LocalDate dateOfBirth;

    public Person(String name) {
        this.name = name;
        this.dateOfBirth = LocalDate.now();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

}
