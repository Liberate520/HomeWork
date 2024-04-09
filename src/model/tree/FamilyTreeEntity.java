package model.tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.entity.*;

public abstract class FamilyTreeEntity {

    private String name;
    private Gender gender;
    private LocalDate birthYear;
    private LocalDate deathYear;
    private Person mother;
    private Person father;

    private List<FamilyTreeEntity> children;

    protected FamilyTreeEntity(String name, Gender gender, LocalDate birthYear){
            this.name = name;
            this.gender = gender;
            this.birthYear = birthYear;
            this.children = new ArrayList<>();

    }


    public String getName() {
        return null;
    }

    public Gender getGender() {
        return null;
    }

    public LocalDate getBirthYear() {
        return null;
    }

    public LocalDate getDeathYear() {
        return null;
    }

    public void setDeathYear(LocalDate deathYear) {

    }

    public List<FamilyTreeEntity> getChildren() {
        return null;
    }

    public void addChild(Person child) {

    }

    public Person getMother() {
        return null;
    }

    public void setMother(Person mother) {

    }

    public Person getFather() {
        return null;
    }

    public void setFather(Person father) {

    }

    public abstract void addChild(FamilyTreeEntity child);

}
