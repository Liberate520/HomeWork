package ru.gb.family_tree;

import java.time.LocalDate;
import java.util.List;

public class Human {
    String name;
    Gender gender;
    LocalDate birthDate, deathDate;
    List<Human> parents;
    List<Human> children;

}
