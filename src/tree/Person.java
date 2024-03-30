package tree;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Person extends FamilyTreeEntity implements Serializable {
    private String name;
    private Gender gender;
    private LocalDate birthYear;
    private LocalDate deathYear;
    private Person mother;
    private Person father;

    private List<FamilyTreeEntity> children;

    public Person(String name, Gender gender, LocalDate birthYear) {
        super(name,gender,birthYear);
        this.name = name;
        this.gender = gender;
        this.birthYear = birthYear;
        this.children = new ArrayList<>();
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    @Override
    public LocalDate getBirthYear() {
        return birthYear;
    }

    @Override
    public LocalDate getDeathYear() {
        return deathYear;
    }

    @Override
    public void setDeathYear(LocalDate deathYear) {
        this.deathYear = deathYear;
    }

    @Override
    public List<FamilyTreeEntity> getChildren() {
        return children;
    }

    @Override
    public void addChild(FamilyTreeEntity child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return name + " (" + gender + ") - " + birthYear + (deathYear != null ? "-" + deathYear : "");
    }
}
