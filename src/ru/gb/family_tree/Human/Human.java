package ru.gb.family_tree.Human;

import java.time.LocalDate;
import java.util.List;

public class Human {
    private long id;
    private String name, lastName;
    private LocalDate dob, dod;
    private Gender gender;
    private Human mother, father;
    private List<Human> children;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getDod() {
        return dod;
    }

    public void setDod(LocalDate dod) {
        this.dod = dod;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
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

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public Human() {
    }

    public Human(
            long id,
            String name,
            String lastName,
            LocalDate dob,
            LocalDate dod,
            Gender gender,
            Human mother,
            Human father,
            List<Human> children) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dob = dob;
        this.dod = dod;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.children = children;
    }

    //TODO Методы работы с классом Human
    /*
    addChild
    addParents
    searchHuman
    searchChildren
    searchParents
    changeHuman
    getAge
     */
    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", dod=" + dod +
                ", gender=" + gender +
                ", mother=" + mother +
                ", father=" + father +
                ", children=" + children +
                '}';
    }
}
