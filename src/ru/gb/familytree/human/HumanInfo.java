package ru.gb.familytree.human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HumanInfo implements Serializable {
    String name;
    LocalDate dob; // дата рождения
    LocalDate dod; // дата смерти
    Gender gender;
    HumanInfo father;
    HumanInfo mother;
    List<HumanInfo> children;

    public HumanInfo(String name, LocalDate dob, LocalDate dod, Gender gender) {
        this.name = name;
        this.dob = dob;
        this.dod = dod;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public LocalDate getDod() {
        return dod;
    }

    public Gender getGender() {
        return gender;
    }

    public HumanInfo getFather() {
        return father;
    }

    public void setFather(HumanInfo father) {
        this.father = father;
    }

    public HumanInfo getMother() {
        return mother;
    }

    public void setMother(HumanInfo mother) {
        this.mother = mother;
    }

    public List<HumanInfo> getChildren() {
        return children;
    }

    public void addChild(HumanInfo child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return name + ", DOB: " + dob + ", DOD: " + (dod != null ? dod : "N/A") + ", Gender: " + gender;
    }
}
