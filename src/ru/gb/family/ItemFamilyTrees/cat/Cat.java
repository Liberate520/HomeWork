package ru.gb.family.ItemFamilyTrees.cat;

import ru.gb.family.ItemFamilyTrees.ItemFamilyTree;
import ru.gb.family.ItemFamilyTrees.enums.Gender;

import java.time.LocalDate;

public class Cat extends ItemFamilyTree {
    private String color;

    public Cat(String name, LocalDate birthday, LocalDate dateOfDeath, Gender gender) {
        super(name, birthday, dateOfDeath, gender);
    }
}
