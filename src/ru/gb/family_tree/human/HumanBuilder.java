package ru.gb.family_tree.human;

import java.io.Serializable;
import java.time.LocalDate;

public class HumanBuilder implements Serializable {
    private int genId;

    public Human build(String name, Gender gender, LocalDate birthDate){
        return new Human(genId++,name, gender, birthDate, null,null,null);
    }

    public Human build(String name, Gender gender, LocalDate birthDate, Object o, Human father, Human mother) {
        return new Human(genId++,name, gender, birthDate, null,father,mother);
    }
}

