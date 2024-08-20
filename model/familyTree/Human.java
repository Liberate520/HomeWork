package model.familyTree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Comparable<Human>, FamilyTreeMember<Human> {
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> parents = new ArrayList<>();
    private List<Human> children = new ArrayList<>();

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
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
        this.parents.add(parent);
        parent.children.add(this);
    }

    @Override
    public int compareTo(Human other) {
        return this.birthDate.compareTo(other.birthDate);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Gender: " + gender + ", Birth Date: " + birthDate + 
               ", Death Date: " + (deathDate == null ? "Alive" : deathDate);
    }
}
