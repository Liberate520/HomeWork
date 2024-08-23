package model.familyTree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements FamilyTreeMember<Human> {
    private String id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> parents;
    private List<Human> children;

    public Human(String id, String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public LocalDate getDeathDate() {
        return deathDate;
    }

    @Override
    public void addParent(Human parent) {
        parents.add(parent);
    }

    public void addChild(Human child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return "Человек{ID = " + id + ", Имя = " + name + ", Пол = " + gender + ", День рождения = " + birthDate + ", Дата смерти = " + deathDate + "}";
    }
}