package ru.gb2.family_tree7.model.human;

import ru.gb2.family_tree7.model.group.GroupItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Comparable<Human>, GroupItem {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> children;  // Список детей
    private Human father;          // Родитель (отец)
    private Human mother;          // Родитель (мать)

    public Human(int id, String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.children = new ArrayList<>();  // Инициализация списка детей
    }

    // Конструктор для создания объекта с только id и именем
    public Human(int id, String name) {
        this(id, name, null, null, null); // Используем основной конструктор с null для остальных полей
    }

    // Метод для добавления ребенка и установления родительских связей
    public void addChild(Human child) {
        if (child != null) {
            children.add(child); // Добавляем ребенка в список детей

            // Устанавливаем родительские связи
            if (this.gender == Gender.MALE) {
                child.father = this;  // Устанавливаем отца
            } else {
                child.mother = this;  // Устанавливаем мать
            }
        }
    }

    // Метод для получения списка детей
    public List<Human> getChildren() {
        return children;
    }

    // Геттеры для получения информации о собственных полях
    public int getId() {
        return id;
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

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    @Override
    public int compareTo(Human other) {
        return this.name.compareTo(other.name); // Сравнение по имени
    }

    @Override
    public String toString() {
        return "Человек{id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthDate=" + birthDate +
                ", deathDate=" + deathDate + '}';
    }
}