package ru.gb.famile_tree.Human;

import java.io.Serializable;
import java.time.*;
import java.util.HashSet;
import java.util.Set;

public class Human implements Serializable {
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
//    private List<Human> children;
    private Set<Human> children;

    public Human(String name, LocalDate birthDate, LocalDate deathDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.children = new HashSet<>();
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

    public Set<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public int getAge() {
        LocalDate endDate = (deathDate != null) ? deathDate : LocalDate.now();
        return Period.between(birthDate, endDate).getYears();
    }
}

