package ru.gb.family_tree.human;

import ru.gb.family_tree.family_tree.ElementFamilyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, ElementFamilyTree<Human> {
    private long id;
    private String name;
    private LocalDate dateOfBirth, dateOfDeath;
    private Gender gender;
    private Human father, mother;
    private List<Human> children;

    public Human(long id, String name, LocalDate dateOfBirth, Gender gender, Human father, Human mother) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LocalDate getBirthDate() {
        return dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    @Override
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

    @Override
    public List<Human> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List<Human> children) {
        this.children = children;
    }

    @Override
    public void addChild(Human child) {
        this.children.add(child);
    }

    @Override
    public void addParents(Human parent) {
        if (parent.getGender() == Gender.Male) {
            this.father = parent;
        } else {
            this.mother = parent;
        }
    }

    @Override
    public String getMotherInfo() {
        return mother != null ? mother.getName() : "неизвестно";
    }

    @Override
    public String getFatherInfo() {
        return father != null ? father.getName() : "неизвестно";
    }

    @Override
    public StringBuilder getChildrenInfo() {
        if (children.isEmpty()) {
            return new StringBuilder("нет");
        }
        StringBuilder childrenNames = new StringBuilder();
        for (Human child : children) {
            if (childrenNames.length() > 0) {
                childrenNames.append(", ");
            }
            childrenNames.append(child.getName());
        }
        return childrenNames;
    }

    @Override
    public int getAge() {
        LocalDate endDate = dateOfDeath != null ? dateOfDeath : LocalDate.now();
        return dateOfBirth.until(endDate).getYears();
    }

    @Override
    public int compareTo(Human other) {
        return Long.compare(this.id, other.id);
    }

    @Override
    public String getBasicInfo() {
        return "ID: " + id +
                ", Имя: " + name +
                ", пол: " + (gender == Gender.Male ? "мужской" : "женский") +
                ", дата рождения: " + dateOfBirth +
                ", дата смерти: " + (dateOfDeath != null ? dateOfDeath : (gender == Gender.Male ? "жив" : "жива"));
    }

    @Override
    public String toString() {
        return getBasicInfo() + ", дети: " + getChildrenInfo();
    }
}
