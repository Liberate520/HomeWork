package com.example.familytree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Date birthDate;
    private Date deathDate;
    private String gender;
    private Person mother;
    private Person father;
    private List<Person> children;

    public Person(String name, Date birthDate, String gender, Person mother, Person father) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
    }

    // Getters and setters for new fields
    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", deathDate=" + deathDate +
                ", gender='" + gender + '\'' +
                ", mother=" + (mother != null ? mother.getName() : "null") +
                ", father=" + (father != null ? father.getName() : "null") +
                ", children=" + children +
                '}';
    }
}
