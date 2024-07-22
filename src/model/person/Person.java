package model.person;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Person implements Serializable {
    private String name;
    private String gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Person mother;
    private Person father;
    private List<Person> children;

    public Person(String name, String gender, LocalDate birthDate, LocalDate deathDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFather() {
        return father;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    // Static methods for sorting
    public static Comparator<Person> sortByName() {
        return Comparator.comparing(Person::getName);
    }

    public static Comparator<Person> sortByBirthDate() {
        return Comparator.comparing(Person::getBirthDate);
    }
}
