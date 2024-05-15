package family_tree;

import java.time.LocalDate;
import java.util.List;

public class Human {
    private int id;
    private String name;
    private String surName;
    private LocalDate dateOfBirth, dateOfDead;
    private List<Human> children;
    private Human father, mother;
    private Sex sex;

    public Human(String name, String surName, LocalDate dateOfBirth, Sex sex) {
        this.name = name;
        this.surName = surName;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public LocalDate getDateOfDead() {
        return dateOfDead;
    }

    public void setDateOfDead(LocalDate dateOfDead) {
        this.dateOfDead = dateOfDead;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
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
}
