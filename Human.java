package com.oop.homeWorkOOP;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Human {
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human father;
    private Human mother;
    private List<Human> children;

    @Override
    public String toString() {
        // if (Objects.isNull(children))
        // return "Неизвестен.";
        // else
        return "Name=" + name + ", age=" + getAge() + ", birthDate=" + birthDate + ", deathDate=" + deathDate;
    }

    public Human(String name, int bDay, int bMonth, int bYear, Human father, Human mother, List<Human> children) {
        this.name = name;
        this.birthDate = LocalDate.of(bYear, bMonth, bDay);
        this.father = father;
        this.mother = mother;
        if (Objects.isNull(children)) {
            children = new ArrayList<>();
        } else {
            this.children = children;
        }
        this.deathDate = null;
    }

    public Human(String name, int bDay, int bMonth, int bYear, int dDay, int dMonth, int dYear, Human father,
            Human mother, List<Human> children) {
        this(name, bDay, bMonth, bYear, father, mother, children);
        this.deathDate = LocalDate.of(dYear, dMonth, dDay);
    }

    public int getAge() {
        if (Objects.isNull(deathDate)) {
            return LocalDate.now().getYear() - birthDate.getYear();
        }
        return deathDate.getYear() - birthDate.getYear();
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {

        return deathDate;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void addChild(Human human) {
        if (Objects.isNull(children)) {
            children = new ArrayList<>();
        }
        children.add(human);
    }
}
