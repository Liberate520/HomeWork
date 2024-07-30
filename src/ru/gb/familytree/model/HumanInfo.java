package ru.gb.familytree.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HumanInfo implements Serializable {
    private String name;
    private LocalDate dob;
    private LocalDate dod;
    private Gender gender;
    private HumanInfo father;
    private HumanInfo mother;
    private List<HumanInfo> children;

    public HumanInfo(String name, LocalDate dob, LocalDate dod, Gender gender) {
        this.name = name;
        this.dob = dob;
        this.dod = dod;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

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

    public void addChild(HumanInfo child) {
        this.children.add(child);
    }

    public List<HumanInfo> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "HumanInfo{" +
                "name='" + name + '\'' +
                ", dob=" + dob +
                ", dod=" + dod +
                ", gender=" + gender +
                ", father=" + (father != null ? father.getName() : "N/A") +
                ", mother=" + (mother != null ? mother.getName() : "N/A") +
                ", children=" + children +
                '}';
    }
}