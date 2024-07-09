package ru.gb.family_tree.human;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import ru.gb.family_tree.human.Gender;

public class Human {
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human>children;

    public Human (String firstName, String lastName, LocalDate dateOfBirth, LocalDate dateOfDeath,
                  Gender gender, Human father, Human mother){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    // добавление ребенка
    public void addChild(Human child) {
        children.add(child);
    }

    // вывод родителей ребенка
    public void printParents() {
        System.out.println("Father: " + father.getFirstName() + " " + father.getLastName());
        System.out.println("Mother: " + mother.getFirstName() + " " + mother.getLastName());
    }

    // вывод детей у родителя
    public void printChildren() {
        for (Human child : children) {
            System.out.println("Child: " + child.getFirstName() + " " + child.getLastName());
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
