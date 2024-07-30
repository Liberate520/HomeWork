package ru.gb.family_tree.builder;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;

import java.time.LocalDate;

public class HumanBuilder {
    private int genId;

    public HumanBuilder() {
    }

    public Human build(String lastName, String firstName, LocalDate dateOfBirth, Gender gender){
        return new Human(genId++, lastName,firstName, dateOfBirth, gender);
    }
    public Human build(String lastName, String firstName, LocalDate dateOfBirth, Gender gender, Human mother, Human father ){
        return new Human(genId++, lastName,firstName, dateOfBirth, gender, mother, father);
    }
}
