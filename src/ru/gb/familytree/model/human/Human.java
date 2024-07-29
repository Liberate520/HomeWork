package ru.gb.familytree.model.human;

import java.time.LocalDate;

public class Human extends SomeBody {

    public Human(String name, LocalDate birth, LocalDate death, int age, Gender gender, SomeBody father, SomeBody mother) {
        super(name, birth, death, age, gender, father, mother);
    }

    public Human(String name, int age, Gender gender) {
        super(name, age, gender);
    }

}