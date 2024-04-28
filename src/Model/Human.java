package Model;

import java.time.LocalDate;


public class Human implements FamilyTreeEmelent {
    private String name;
    private LocalDate dob;
    private LocalDate dod;
    private Gender gender;
    private Human father, mother;
    private boolean check;

    // Первый конструктор
    public Human(String name, LocalDate dob, Gender gender) {
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.check = false;
    }

    // Второй расширенный конструктор
    public Human(String name, LocalDate dob, Gender gender, LocalDate dod) {
        this(name, dob, gender);
        this.dod = dod;
        this.check = true;
    }

    // Getters and Setters
    public String getName(){
        return name;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return dob;
    }

    @Override
    public LocalDate getDeathDate() {
        return dod;
    }

    @Override
    public Gender getGender() {
        return gender;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    @Override
    public String toString() {
        if (check) {
            return getInfoTrue();
        } else {
            return getInfoFalse();
        }
    }

    private String getInfoTrue(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name = " + name + ": Gender = " + gender + ": Birthday = " + dob + ": Dead = " + dod);
        return sb.toString();
    }

    private String getInfoFalse(){
        StringBuilder sb = new StringBuilder();
        sb.append("Name = " + name + ": Gender = " + gender + ": DOB = " + dob);
        return sb.toString();
    }
}