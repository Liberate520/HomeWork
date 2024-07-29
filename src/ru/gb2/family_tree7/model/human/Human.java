package ru.gb2.family_tree7.model.human;

import ru.gb2.family_tree7.model.family_tree.TreeNode;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements TreeNode<Human> {
    private long id; // Уникальный идентификатор
    private String name;
    private LocalDate birthDate; // Дата рождения
    private LocalDate deathDate; // Дата смерти
    private Gender gender;
    private List<Human> parents = new ArrayList<>(); // Список родителей
    private List<Human> children = new ArrayList<>(); // Список детей

    public Human(long id, String name, LocalDate birthDate, Gender gender) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    // Геттеры
    public long getId() {
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

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildren() {
        return children;
    }

    // Сеттеры
    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void addParent(Human parent) {
        parents.add(parent);
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public void removeParent(Human parent) {
        parents.remove(parent);
    }

    public void removeChild(Human child) {
        children.remove(child);
    }

    // Метод для вычисления возраста
    public int getAge() {
        if (birthDate == null) {
            throw new IllegalArgumentException("Дата рождения не может быть null");
        }
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }
}