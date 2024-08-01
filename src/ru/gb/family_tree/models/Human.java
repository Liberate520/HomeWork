package ru.gb.family_tree.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

// Класс, описывающий человека
public class Human implements Serializable {
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

    public List<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public void addParent(Human parent) {
        parents.add(parent);
    }

    public void setDeathDate(String deathDate) {
        this.deathDate = LocalDate.parse(deathDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public int getAge() {
        if (deathDate != null) {
            return Period.between(birthDate, deathDate).getYears();
        } else {
            return Period.between(birthDate, LocalDate.now()).getYears();
        }
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
