package Family_tree;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Human {
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    public LinkedList<Human> parents;
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

    public List<Human> getParents() {
        return parents;
    }

    public void addParent(Human parent1, Human parent2) {
        this.parents.add(parent1);
        this.parents.add(parent2);
    }

    public List<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", Пол: " + gender + ", Дата рождения: " + birthDate + ", Дата смерти: " + deathDate;
    }
}
