package ru.gb.family_tree.model.item;

import java.time.LocalDate;

public class Human extends FamilyTreeItem<Human> {

    public Human(long id, String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father,
            Human mother) {
        super(id, name, gender, birthDate, deathDate, father, mother);
    }

    public Human(long id, String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
        super(id, name, gender, birthDate, null, father, mother);
    }

    public Human(long id, String name, Gender gender, LocalDate birthDate) {
        super(id, name, gender, birthDate, null, null, null);
    }
}
