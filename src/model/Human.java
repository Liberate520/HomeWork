package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements FamilyMember<Human>, Serializable {

    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> children;
    private List<Human> parents;

    public Human(String name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = null;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Gender getGender() {
        return gender;
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
    public List<Human> getChildren() {
        return children;
    }

    @Override
    public List<Human> getParents() {
        return parents;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void setParents(List<Human> parents) {
        this.parents = parents;
    }

    @Override
    public void addChild(Human child) {
        children.add(child);
        child.addParent(this);
    }

    @Override
    public void addParent(Human parent) {
        if (parents.size() < 2) {
            parents.add(parent);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name)
                .append(" (").append(gender)
                .append("), Birth Date: ").append(birthDate);
        if (deathDate != null) {
            sb.append(", Death Date: ").append(deathDate);
        }
        if (!parents.isEmpty()) {
            sb.append(", Parents: ");
            for (Human parent : parents) {
                sb.append(parent.getName()).append(" ");
            }
        } else {
            sb.append(", Parents: None");
        }
        return sb.toString();
    }
}
