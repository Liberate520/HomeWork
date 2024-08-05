package ru.gb.family_tree.human.builder;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;

import java.io.Serializable;
import java.time.LocalDate;

public class HumanBuilder implements Serializable {
    private long genId;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private Human father;
    private Human mother;

    // TODO хотел сделать добавление ID (++)

    public Human build(String name, Gender gender, LocalDate birthDate, Object o, Object object){
        return new Human(this.name, this.gender, this.birthDate, father, mother);
    }
}
