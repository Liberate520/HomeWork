package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements FamilyMember, Serializable{

    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<FamilyMember> children;
    private List<FamilyMember> parents;
    //private List<Relationship> relationships;

    public Human(String name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.children = new ArrayList<>();
        this.parents = new ArrayList<>();
        //this.relationships = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public List<FamilyMember> getChildren() {
        return children;
    }

    public List<FamilyMember> getParents() {
        return parents;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthday(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void setParents(List<FamilyMember> parents) {
        this.parents = parents;
    }

    public void addChild(FamilyMember child) {
        children.add(child);
        child.addParent(this);
    }

    public void addParent(FamilyMember parent) {
        if (parents.size() < 2) {
            parents.add(parent);
        }
    }

    @Override
    public String toString() {
        return name + " (" + gender + "), Birth Date: " + birthDate + (deathDate != null ? ", Death Date: " + deathDate : "");
    }
}
