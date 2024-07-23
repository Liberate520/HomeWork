package ru.gb.family_tree;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private LocalDate birthDate;
    private String firstName;
    private String middleName;
    private String lastName;
    private Gender gender;
    private Nationality nationality;
    private String placeOfBirth;
    private Human mother;
    private Human father;
    private List<Human> children;
    private LocalDate deathDate;

    public Human(LocalDate birthDate, String firstName, String middleName, String lastName, Gender gender, 
                 Nationality nationality, String placeOfBirth, Human mother, Human father, LocalDate deathDate) {
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.nationality = nationality;
        this.placeOfBirth = placeOfBirth;
        this.mother = mother;
        this.father = father;
        this.deathDate = deathDate;
        this.children = new ArrayList<>();
    }

    public Human(LocalDate birthDate, String firstName, String middleName, String lastName, Gender gender, 
    Nationality nationality, String placeOfBirth, Human mother, Human father) {
        this(birthDate, firstName, middleName, lastName, gender, nationality, placeOfBirth, mother, father, null);
    }

    public Human(LocalDate birthDate, String firstName, String middleName, String lastName, Gender gender, 
    Nationality nationality, String placeOfBirth, Human mother) {
        this(birthDate, firstName, middleName, lastName, gender, nationality, placeOfBirth, mother, null, null);
    }
    public Human(LocalDate birthDate, String firstName, String middleName, String lastName, Gender gender, 
    Nationality nationality, String placeOfBirth) {
        this(birthDate, firstName, middleName, lastName, gender, nationality, placeOfBirth, null, null, null);
    }
    public Human(LocalDate birthDate, String firstName, String middleName, String lastName, Gender gender, 
    Nationality nationality) {
        this(birthDate, firstName, middleName, lastName, gender, nationality, "", null, null, null);
    }
    public Human(LocalDate birthDate, String firstName, String middleName, String lastName, Gender gender) {
        this(birthDate, firstName, middleName, lastName, gender, null, "", null, null, null);
    }

    // Геттеры и сеттеры
    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void addChild(Human child) {
        this.children.add(child);
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    // Полное имя
    public String getFullName() {
        return String.format("%s %s %s", firstName, middleName, lastName);
    }

    @Override
    public String toString() {
        return String.format("Human{name='%s', gender=%s, birthDate=%s, placeOfBirth='%s', deathDate=%s}",
                getFullName(), gender, birthDate, placeOfBirth, deathDate);
    }
}