package FamilyTree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Gender gender;
    private String occupation;
    private String nationality;
    private String placeOfBirth;

    private Human father;
    private Human mother;
    private List<Human> children;
    private Human spouse;

    public Human(String name,
                 LocalDate birthDate,
                 LocalDate deathDate,
                 Gender gender,
                 String occupation,
                 String nationality,
                 String placeOfBirth,
                 Human father,
                 Human mother) {

        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.occupation = occupation;
        this.nationality = nationality;
        this.placeOfBirth = placeOfBirth;

        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
    }

    public Human(String name, LocalDate birthDate, Gender gender) {
        this(name, birthDate, null, gender, null, null, null, null, null);
    }

    public Human(String name, LocalDate birthDate, Gender gender, Human father, Human mother) {
        this(name, birthDate, null, gender, null, null, null, father, mother);
    }


    // Getters and Setters

    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Gender getGender() {
        return gender;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public List<Human> getChildren() {
        return children;
    }

//    public void addChild(Human child){if(!children.contains(child)){children.add(child);}if(this.gender==Gender.Male&&child.getFather()!=this){child.setFather(this);}else if(this.gender==Gender.Female&&child.getMother()!=this){child.setMother(this);}}

    public void addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
        }
        if (this.gender == Gender.Male && child.getFather() != this) {
            child.setFather(this);
        } else if (this.gender == Gender.Female && child.getMother() != this) {
            child.setMother(this);
        }
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getSpouse() {
        return spouse;
    }
}