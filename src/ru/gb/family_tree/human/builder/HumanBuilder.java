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

    public Human build(){
        Human human = new Human(name, gender, birthDate, father, mother);
        return human;
    }
}
