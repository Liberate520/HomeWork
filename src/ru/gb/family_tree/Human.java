package ru.gb.family_tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private LocalDate birthDate;
    private String firstName;
    private String middleName;
    private String lastName;
    private Gender gender;
    private Nationality nationality;
    private String placeOfBirth;
    private Human mother;
    private Human father;
    private List<Human> children;
    private LocalDate deathDate;

    public Human(String firstname, Gender gender, LocalDate birthDate, Human mother, Human father) {
        this.firstName = firstname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.mother = mother;
        this.father = father;
        this.children = new ArrayList<>();
    }

    // Геттеры и сеттеры
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        this.children.add(child);
    }
}
