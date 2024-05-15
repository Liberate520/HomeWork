package ru.gb.family_tree;

import java.time.LocalDate;
import java.util.List;

public class Human {
    private String name;
    private String lastName;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Human father;
    private Human mather;
    private List<Human> child;
    private List<Human> marriedPartner;


}
