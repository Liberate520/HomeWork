package ru.gb.family_tree.model.builder;

import ru.gb.family_tree.model.Human.Gender;
import ru.gb.family_tree.model.Human.Human;

import java.time.LocalDate;

public class HumanBuilder {
    public long genID;

    public Human build(String lastName, String name, Gender gender, LocalDate birthDate) {
        return new Human(genID++, lastName, name, gender, birthDate);
    }
}
