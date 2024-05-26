package ru.gb.family_tree;

import java.time.LocalDate;
import java.util.List;

public class Human {
    private String name;
    private Human mother. father;
    private List<Human> children;
    private LocalDate birthDate, deathDate;
    private Gender gender;
}
