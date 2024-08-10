package ru.marat.geekbrains.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.Period;


public class Person {
    private String name;
    private LocalDate birthDate;
    private Person mother;
    private Person father;
    private String gender;
    private List<Person> children;

    public Person(String name, LocalDate birthDate, String gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public String getGender() {
        return gender;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    public <T extends Person> List<T> getChildren() {
        return (List<T>) children;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Birth Date: %s, Age: %d, Gender: %s", name, birthDate, getAge(), gender);
    }
}
