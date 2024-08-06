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

    public int getId() {
        return id;
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

    public void setDeathDate(String deathDate) {
        this.deathDate = LocalDate.parse(deathDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public String getGender() {
        return gender;
    }

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
        if (!this.children.contains(child)) {
            this.children.add(child);
            child.addParent(this);
        }
    }

    @Override
    public void addParent(Human parent) {
        if (!this.parents.contains(parent)) {
            this.parents.add(parent);
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

    public int getAge() {
        LocalDate endDate = (deathDate != null) ? deathDate : LocalDate.now();
        return Period.between(birthDate, endDate).getYears();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ").append(id)
                .append(", Имя: ").append(name)
                .append(", Пол: ").append(gender)
                .append(", Дата рождения: ").append(birthDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        if (deathDate != null) {
            sb.append(", Дата смерти: ").append(deathDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        }
        sb.append(", Возраст: ").append(getAge());

        if (!children.isEmpty()) {
            sb.append(", Дети: [");
            for (Human child : children) {
                sb.append(child.getName()).append(", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append("]");
        } else {
            sb.append(", Дети: отсутствуют");
        }

        if (!parents.isEmpty()) {
            sb.append(", Родители: [");
            for (Human parent : parents) {
                sb.append(parent.getName()).append(", ");
            }
            sb.setLength(sb.length() - 2);
            sb.append("]");
        } else {
            sb.append(", Родители: отсутствуют");
        }

        if (spouse != null) {
            sb.append(", Супруг(а): ").append(spouse.getName());
        } else {
            sb.append(", Супруг(а): отсутствует");
        }

        return sb.toString();
    }
}
