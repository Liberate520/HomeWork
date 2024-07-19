package com.example.familytree.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

// Класс Person представляет человека
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String name;
    private LocalDate birthDate;
    private String gender;
    private List<Person> parents;
    private List<Person> children;

    public Person(int id, String name, LocalDate birthDate, String gender) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public int getId() {
        return id;
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

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public List<Person> getParents() {
        return parents;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addParent(Person parent) {
        if (!this.parents.contains(parent)) {
            this.parents.add(parent);
        }
    }

    public void addChild(Person child) {
        if (!this.children.contains(child)) {
            this.children.add(child);
            child.addParent(this);
        }
    }

    @Override
    public String toString() {
        return "ID=" + id + ", Имя='" + name + '\'' + ", Возраст=" + getAge() + ", Пол='" + gender + '\'';
    }
}