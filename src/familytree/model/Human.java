package familytree.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private List<Human> children;
    private List<Human> parents;

    public Human(String name, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
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

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    public List<Human> getChildren() {
        return children;
    }

    public List<Human> getParents() {
        return parents;
    }

    public void addChild(Human child) {
        this.children.add(child);
        child.getParents().add(this);
    }

    public boolean isAlive() {
        return deathDate == null;
    }

    public int getAge() {
        LocalDate endDate = (deathDate != null) ? deathDate : LocalDate.now();
        return Period.between(birthDate, endDate).getYears();
    }
}