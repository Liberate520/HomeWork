package ru.as.family_tree.human;

import java.time.LocalDate;

public class Human {
    private String name;
    private LocalDate berthDate;
    private Gender gender;


    public Human(String name, LocalDate berthDate, Gender gender) {
        this.name = name;
        this.berthDate = berthDate;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public LocalDate getBerthDate() {
        return berthDate;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "name:" + name + ", berfhDate: " + berthDate + ", gender: " + gender;
    }
}
