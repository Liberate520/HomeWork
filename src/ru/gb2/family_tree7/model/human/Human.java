package ru.gb2.family_tree7.model.human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private final String name;
    private final Gender gender;
    private final LocalDate birthDate;
    private final LocalDate deathDate;
    private final List<Human> children;

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.children = new ArrayList<>();
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public List<Human> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getAge() {
        return (deathDate != null ? deathDate : LocalDate.now()).getYear() - birthDate.getYear();
    }
}