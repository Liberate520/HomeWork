package tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class FamilyTreeEntity {

    private String name;
    private Gender gender;
    private LocalDate birthYear;
    private LocalDate deathYear;
    private Person mother;
    private Person father;

    private List<FamilyTreeEntity> children;

    FamilyTreeEntity(String name, Gender gender, LocalDate birthYear){
            this.name = name;
            this.gender = gender;
            this.birthYear = birthYear;
            this.children = new ArrayList<>();

    }


    String getName() {
        return null;
    }

    Gender getGender() {
        return null;
    }

    LocalDate getBirthYear() {
        return null;
    }

    LocalDate getDeathYear() {
        return null;
    }

    void setDeathYear(LocalDate deathYear) {

    }

    List<FamilyTreeEntity> getChildren() {
        return null;
    }

    void addChild(Person child) {

    }

    Person getMother() {
        return null;
    }

    void setMother(Person mother) {

    }

    Person getFather() {
        return null;
    }

    void setFather(Person father) {

    }

    public abstract void addChild(FamilyTreeEntity child);
}
