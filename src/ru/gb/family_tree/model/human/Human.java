package ru.gb.family_tree.model.human;

import ru.gb.family_tree.model.member.Gender;
import ru.gb.family_tree.model.member.Member;

import java.time.LocalDate;

public class Human extends Member {
    public Human(String name, LocalDate birthDate, Gender gender) {
        super(name, birthDate, gender);
    }

    public Human(String name, Member mother, Member father, LocalDate birthDate, LocalDate deathDate, Gender gender) {
        super(name, mother, father, birthDate, deathDate, gender);
    }
}