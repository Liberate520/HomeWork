package ru.gb.family_tree.human.builder;

import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;

import java.time.LocalDate;
import java.util.List;

public class HumanBuilder implements List<T> {
    private long genId;


    public Human build(String name, Gender gender, LocalDate birthDate){
        return new Human(genId++, name, gender, birthDate);
    }
}
