package ru.gb.family_tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Node implements Serializable {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private Node spouse;
    private Node father;
    private Node mother;
    private List<Node> children;

    public Node(String name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.children = new ArrayList<>();
    }

    public Node(String name, Gender gender, LocalDate birthDate, Node spouse, Node father, Node mother) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.spouse = spouse;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setMother(Node mother) {
        this.mother = mother;
    }

    @Override
    public String toString() {
        String spouseName = (spouse == null) ? "нет" : spouse.getName();
        String fatherName = (father == null) ? "неизвестен" : father.getName();
        String motherName = (mother == null) ? "неизвестна" : mother.getName();
        return "id: " + id + ", имя: " + name + ", пол: " + gender + ", возраст: " + calculateAge() +
                ", супруг(а): " + spouseName + ", мать: " + motherName + ", отец: " + fatherName +
                ", дети: " + (children.isEmpty() ? "отсутствуют" : children.size());
    }

    private int calculateAge() {
        return LocalDate.now().getYear() - birthDate.getYear();
    }
}