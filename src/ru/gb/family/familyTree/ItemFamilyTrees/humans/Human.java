package ru.gb.family.familyTree.ItemFamilyTrees.humans;

import ru.gb.family.familyTree.ItemFamilyTrees.ItemFamilyTree;
import ru.gb.family.familyTree.ItemFamilyTrees.enums.Gender;
import ru.gb.family.familyTree.ItemFamilyTrees.enums.Сountries;

import java.time.LocalDate;


public class Human extends ItemFamilyTree {
    private Сountries сountry;

    public Human(String name, LocalDate birthday, LocalDate dateOfDeath, Gender gender, Сountries сountry) {
        super(name, birthday, dateOfDeath, gender);
        this.сountry = сountry;

    }
}
