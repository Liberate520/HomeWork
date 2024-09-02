package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, FamilyMember {
    private LocalDate birthDate, deathDate;
    private Gender gender;
    private List<FamilyMember> children;
    private String name;
    private List<FamilyMember> parents;

    public Human(String name, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public List<FamilyMember> getParents() {
        return parents;
    }

    @Override
    public List<FamilyMember> getChildren() {
        return children;
    }

    @Override
    public void addParent(FamilyMember parent) {
        this.parents.add(parent);
    }

    @Override
    public void addChild(FamilyMember child) {
        this.children.add(child);
    }

    @Override
    public int getAgeAt(LocalDate date) {
        LocalDate endDate = (deathDate != null) ? deathDate : date;
        return Period.between(birthDate, endDate).getYears();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ").append(name);
        sb.append(", Дата рождения: ").append(birthDate);
        if (deathDate != null) {
            sb.append(", Дата смерти: ").append(deathDate);
        }
        sb.append(", Пол: ").append(gender);
        sb.append(", Возраст: ").append(getAgeAt(LocalDate.now()));
        if (!parents.isEmpty()) {
            sb.append(", Родители: ");
            for (FamilyMember parent : parents) {
                sb.append(parent.getName()).append(" ");
            }
        }
        return sb.toString();
    }
}