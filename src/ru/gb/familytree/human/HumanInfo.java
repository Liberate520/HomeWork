package ru.gb.familytree.human;

import ru.gb.familytree.familytree.FamilyMember;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HumanInfo extends FamilyMember implements Serializable {
    private LocalDate dob; // Date of Birth
    private LocalDate dod; // Date of Death
    private Gender gender;
    private HumanInfo father;
    private HumanInfo mother;
    private List<HumanInfo> children;

    public HumanInfo(String name, LocalDate dob, LocalDate dod, Gender gender) {
        super(name);
        this.dob = dob;
        this.dod = dod;
        this.gender = gender;
        this.children = new ArrayList<>();
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
        this.children.add(child);
    }

    @Override
    public String toString() {
        return super.toString() + ", DOB: " + dob + ", DOD: " + (dod != null ? dod : "N/A") + ", Gender: " + gender;
    }
}
