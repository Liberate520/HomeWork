package Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import FamilyTree.HasId;
import FamilyTree.HasChildren;

public class Human implements HasId, HasChildren<Human>, Serializable {
    private int id;
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(int id, String name, LocalDate birthDate, LocalDate deathDate, Gender gender, Human father, Human mother) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
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

    @Override
    public List<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        this.children.add(child);
    }

    public int getAge() {
        return Period.between(birthDate, (deathDate != null) ? deathDate : LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        return "Human{" +
        "id: " + id +
        ", Имя: '" + name + '\'' +
        ", Возраст: " + getAge() +
        ", Пол: " + gender +
        ", Отец: " + (father != null ? father.getName() : "неизвестен") +
        ", Мать: " + (mother != null ? mother.getName() : "неизвестна") +
        ", дети: " + children.stream().map(Human::getName).collect(Collectors.toList()) +
                '}';
    }
}
