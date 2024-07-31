package ru.gb.familytree;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class Human {
    private String name;
    private Gender gender;
    private LocalDate birthDate, deathDate;
    private List<Human> parents;
    private List<Human> children;

    Human() {
        birthDate = LocalDate.MIN;
        deathDate = LocalDate.MAX;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public List<Human> getParents() {
        return parents;
    }

    public void setParents(List<Human> parents) {
        this.parents = parents;
    }

    public void addParent(Human parent) {
        this.parents.add(parent);
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(List<Human> children) {
        this.children = children;
    }

    public void addChild(Human child) {
        this.children.add(child);
    }
}
