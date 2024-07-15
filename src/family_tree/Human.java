package ru.gb.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private int id;
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private Human father;
    private Human mother;
    private Human spouse;
    private List<Human> children;

    public Human(String name, LocalDate birthDate, Gender gender, Human father, Human mother) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
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

    public Gender getGender() {
        return gender;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public Human getSpouse() {
        return spouse;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public int getAge() {
        LocalDate endDate = (deathDate == null) ? LocalDate.now() : deathDate;
        return Period.between(birthDate, endDate).getYears();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("id: ").append(id).append(", имя: ").append(name)
                .append(", пол: ").append(gender)
                .append(", возраст: ").append(getAge())
                .append(", супруг(a): ").append((spouse != null) ? spouse.getName() : "нет")
                .append(", мать: ").append((mother != null) ? mother.getName() : "неизвестна")
                .append(", отец: ").append((father != null) ? father.getName() : "неизвестен")
                .append(", дети: ");
        if (children.isEmpty()) {
            sb.append("отсутствуют");
        } else {
            for (Human child : children) {
                sb.append(child.getName()).append(", ");
            }
            sb.setLength(sb.length() - 2);
        }
        return sb.toString();
    }
}
