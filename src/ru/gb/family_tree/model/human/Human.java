package ru.gb.family_tree.model.human;

import ru.gb.family_tree.model.family_tree.ElementFamilyTree;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Human implements ElementFamilyTree<Human>, Serializable {
    private long id;
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
    private String fatherName;
    private String motherName;
    private List<Human> children;

    public Human(long id, String name, LocalDate dateOfBirth, Gender gender, String fatherName, String motherName) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.children = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public void addChild(Human child) {
        this.children.add(child);
    }

    public List<Human> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        String childrenNames = children.stream()
                .map(Human::getName)
                .collect(Collectors.joining(", "));

        return String.format("Human{id=%d, name='%s', dateOfBirth=%s, gender=%s, fatherName='%s', motherName='%s', children=[%s]}",
                id, name, dateOfBirth, gender, fatherName, motherName, childrenNames);
    }


    @Override
    public int compareTo(Human other) {
        return this.name.compareTo(other.name);
    }

    @Override
    public LocalDate getBirthDate() {
        return this.dateOfBirth;
    }

    @Override
    public int getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }

}
