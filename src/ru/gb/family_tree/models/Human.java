package ru.gb.family_tree.models;

import ru.gb.family_tree.interfaces.HasRelations;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Human implements HasRelations<Human>, Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private String gender;
    private List<Human> children;
    private List<Human> parents;
    private Human spouse;

    public Human(int id, String name, String birthDate, String gender) {
        this.id = id;
        this.name = name;
        this.birthDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        this.gender = gender;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    // Геттеры и сеттеры...

    @Override
    public List<Human> getChildren() {
        return children;
    }

    @Override
    public List<Human> getParents() {
        return parents;
    }

    @Override
    public void addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            child.addParent(this);
        }
    }

    @Override
    public void addParent(Human parent) {
        if (!parents.contains(parent)) {
            parents.add(parent);
            parent.addChild(this);
        }
    }

    public Human getSpouse() {
        return spouse;
    }

    public void setSpouse(Human spouse) {
        if (this.spouse != null) {
            this.spouse.spouse = null;
        }
        this.spouse = spouse;
        if (spouse != null && spouse.getSpouse() != this) {
            spouse.setSpouse(this);
        }
    }

    // Методы toString() и другие...
}
