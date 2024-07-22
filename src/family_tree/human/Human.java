package ru.gb.family_tree.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private int id;               // ID человека
    private String name;          // Имя человека
    private LocalDate birthDate;  // Дата рождения
    private LocalDate deathDate;  // Дата смерти (может быть null, если человек жив)
    private Gender gender;        // Пол человека
    private Human father;         // Отец
    private Human mother;         // Мать
    private Human spouse;         // Супруг(а)
    private List<Human> children; // Дети

    public Human(String name, LocalDate birthDate, Gender gender, Human father, Human mother) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    // Метод для установки ID
    public void setId(int id) {
        this.id = id;
    }

    // Метод для добавления ребенка
    public void addChild(Human child) {
        children.add(child);
    }

    // Метод для установки супруга
    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    // Геттеры для доступа к полям
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

    // Сеттер для установки даты смерти
    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    // Метод для вычисления возраста
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
            sb.setLength(sb.length() - 2); // Удаление последней запятой и пробела
        }
        return sb.toString();
    }
}
