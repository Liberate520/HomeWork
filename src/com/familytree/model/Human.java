package com.familytree.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements FamilyMember<Human> {
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public LocalDate getDeathDate() {
        return deathDate;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public Human getFather() {
        return father;
    }

    @Override
    public Human getMother() {
        return mother;
    }

    @Override
    public void setMother(Human mother) {
        this.mother = mother;
    }

    @Override
    public void setFather(Human father) {
        this.father = father;
    }

    @Override
    public void addChild(Human child) {
        this.children.add(child);
    }

    @Override
    public List<Human> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return name + " (" + gender + ", " + birthDate + ")";
    }
}