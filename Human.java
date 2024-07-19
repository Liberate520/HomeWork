package Part3_OOP.Seminar1.Family_tree;

import java.time.LocalDate;
import java.util.LinkedList;

public class Human {
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private LinkedList<Human> parents;
    private LinkedList<Human> children;

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.parents = new LinkedList<>();
        this.children = new LinkedList<>();
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

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public LinkedList<Human> getParents() {
        return parents;
    }

    public void addParent(Human parent) {
        this.parents.add(parent);
    }

    public LinkedList<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        this.children.add(child);
    }
}
