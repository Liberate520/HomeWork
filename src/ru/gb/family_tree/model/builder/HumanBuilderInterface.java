package ru.gb.family_tree.model.builder;

import ru.gb.family_tree.model.Human.Gender;
import ru.gb.family_tree.model.Human.Human;

import java.time.LocalDate;

public interface HumanBuilderInterface {
    Human build(String lastName, String name, Gender gender, LocalDate birthDate);
}
