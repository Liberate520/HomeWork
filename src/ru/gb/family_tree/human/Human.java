package ru.gb.family_tree.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private int id;
    private String name;
    private LocalDate dateOfBirth, dateOfDeath;
    private Gender gender;
    private Human father, mother;
    private List<Human> children;

    public Human(int id, String name, LocalDate dateOfBirth, Gender gender, Human father, Human mother) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public Gender getGender() {
        return gender;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        this.children.add(child);
    }

    public String getChildrenAsString() {
        if (children.isEmpty()) {
            return "нет";
        }
        StringBuilder childrenNames = new StringBuilder();
        for (Human child : children) {
            if (childrenNames.length() > 0) {
                childrenNames.append(", ");
            }
            childrenNames.append(child.getName());
        }
        return childrenNames.toString();
    }

    public String getBasicInfo() {
        return "ID: " + id +
                ", Имя: " + name +
                ", пол: " + (gender == Gender.Male ? "мужской" : "женский") +
                ", дата рождения: " + dateOfBirth +
                ", дата смерти: " + (dateOfDeath != null ? dateOfDeath : (gender == Gender.Male ? "жив" : "жива"));
    }

    @Override
    public String toString() {
        return getBasicInfo() + ", дети: " + getChildrenAsString();
    }
}
