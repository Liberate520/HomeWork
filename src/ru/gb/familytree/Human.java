package ru.gb.familytree;

import java.time.LocalDate;

public class Human {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDay;
    private LocalDate deathDay;
    private Human father;
    private Human mother;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public void setDeathDay(LocalDate deathDay) {
        this.deathDay = deathDay;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public LocalDate getDeathDay() {
        return deathDay;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    @Override
    public String toString() {
        return id + ", имя: " + name +
                ", дата рождения: " + birthDay + ", дата смерти: " + deathDay +
                ", пол: " + gender +
                ", отец: " + father + ", мать: " + mother;
    }
}
