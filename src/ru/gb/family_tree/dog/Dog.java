package ru.gb.family_tree.dog;

import java.time.LocalDate;

public class Dog {
    private String name;
    private LocalDate dayOfBirth;
    private LocalDate dayOfDeath;
    private Gender gender;
    private String breed;

    public void setName(String name) {
        this.name = name;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public void setDayOfDeath(LocalDate dayOfDeath) {
        this.dayOfDeath = dayOfDeath;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public LocalDate getDayOfDeath() {
        return dayOfDeath;
    }

    public Gender getGender() {
        return gender;
    }

    public String getBreed() {
        return breed;
    }

    public Dog(String name, LocalDate dayOfBirth, LocalDate dayOfDeath, Gender gender, String breed) {
        this.name = name;
        this.dayOfBirth = dayOfBirth;
        this.dayOfDeath = dayOfDeath;
        this.gender = gender;
        this.breed = breed;
    }


}
