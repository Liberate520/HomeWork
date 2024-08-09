package ru.gb.family_tree.model.human.builder;

import ru.gb.family_tree.model.human.enums.Gender;
import ru.gb.family_tree.model.human.Human;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class HumanBuilder implements Serializable {
    private int genId;

    public Human build(String name, String patronymic, String surname,
                       Gender gender, Human father, Human mother,
                       List<Human> children, String profession,
                       String nationality, LocalDate dateOfBirth, LocalDate dateOfDeath,
                       String birthPlace, String notes){
        return new Human(genId++, name, patronymic, surname, gender, father, mother, children, profession,
                nationality, dateOfBirth, dateOfDeath, birthPlace, notes);
    }

    public void setIdAfterLoad(int id){
        genId = id;
    }

    public Human build(String name, String patronymic, String surname,
                       Gender gender){
        return new Human(genId++, name, patronymic, surname, gender);
    }
}
