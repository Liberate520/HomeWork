package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String birthDate;
    private Gender gender;
    private Person father;
    private Person mother;
    private List<Person> children;

    public Person(String name, String birthDate, Gender gender) {
        this.id = idCounter++;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public void addChild(Person child) {
        children.add(child);
        if (this.gender == Gender.MALE) {
            child.setFather(this);
        } else if (this.gender == Gender.FEMALE) {
            child.setMother(this);
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public List<Person> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", gender=" + gender +
                ", father=" + (father != null ? father.getName() : "no") +
                ", mother=" + (mother != null ? mother.getName() : "no") +
                ", children=" + (children.isEmpty() ? "no" : children) +
                '}';
    }
}
