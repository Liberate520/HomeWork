package ru.gb.familytree.human;

import java.io.Serializable;
import java.time.LocalDate;

public class Human implements Serializable {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDay;
    private LocalDate deathData;
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

    public void setDeathData(LocalDate deathData) {
        this.deathData = deathData;
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

    public LocalDate getDeathData() {
        return deathData;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    private String getInfo() {
        StringBuilder result = new StringBuilder();
        result.append(getId())
                .append(", Имя: ").append(getName())
                .append(", пол: ").append(getGender())
                .append(", дата рождения: ").append(getBirthDay())
                .append(", дата смерти: ").append(getDeathData())
                .append(", отец: ").append(getFather())
                .append(", мать: ").append(getMother());
        return result.toString();
    }
}
