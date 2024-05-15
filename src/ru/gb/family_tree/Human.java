package ru.gb.family_tree;

import java.time.LocalDate;
import java.util.List;

public class Human {
    private String name;
    private String lastName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Human father;
    private Human mather;
    private List<Human> child;
    private Human marriedPartner;

    public Human(String name, String lastName, Gender gender, LocalDate dateOfBirth, LocalDate dateOfDeath, Human father, Human mather, List<Human> child, Human marriedPartner) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.father = father;
        this.mather = mather;
        this.child = child;
        this.marriedPartner = marriedPartner;
    }

    public Human(String иван, String гагарин) {
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMather(Human mather) {
        this.mather = mather;
    }

    public void setChild(List<Human> child) {
        this.child = child;
    }

    public void setMarriedPartner(Human marriedPartner) {
        this.marriedPartner = marriedPartner;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Human{" +
                "Имя: " + name +
                ", Фамилия: " + lastName +
                ", пол: " + gender +
                ", годы жизни: " + dateOfBirth +
                " - " + dateOfDeath +
                ", отец: " + father +
                ", мать: " + mather +
                ", дети: " + child +
                ", супруг: " + marriedPartner +
                '}';
    }
}
