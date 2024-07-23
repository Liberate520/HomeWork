package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person implements TreeNode<Person> {
    private static final long serialVersionUID = 1L;
    private static int idCounter = 1;

    private int id;
    private String name;
    private LocalDate birthDate;
    private Gender gender;
    private List<Person> children;
    private Person father;
    private Person mother;

    public Person(String name, String birthDate, Gender gender) {
        this.id = idCounter++;
        this.name = name;
        this.birthDate = LocalDate.parse(birthDate);
        this.gender = gender;
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

    public Gender getGender() {
        return gender;
    }

    public List<Person> getChildren() {
        return children;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    @Override
    public String toString() {
        return String.format("ID: %d, Имя: %s, Дата рождения: %s, Пол: %s", id, name, birthDate, gender);
    }
}
