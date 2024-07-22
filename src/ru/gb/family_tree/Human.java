package ru.gb.family_tree;

import java.time.LocalDate;
import java.util.List;

public class Human {
    String name;
    Gender gender;
    LocalDate birthDate;
    Human mother;
    Human father;
    List<Human> children;
    
    
}
