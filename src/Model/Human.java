package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private LocalDate birthDate, deathDate;
    private Gender gender;
    private List<Human> children;
    private String name;
    private List<Human> parents;

    public Human(String name, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
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

    public Gender getGender() {
        return gender;
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void addParent(Human parent) {
        this.parents.add(parent);
    }

    public void addChild(Human child) {
        this.children.add(child);
    }

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
            for (Human parent : parents) {
                sb.append(parent.getName()).append(" ");
            }
        }
        return sb.toString();
    }

    public int compareTo(Human o) {
        return name.compareTo(o.name);
    }
}
