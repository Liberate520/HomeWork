package ru.gb.family.ItemFamilyTrees.humans;

import ru.gb.family.ItemFamilyTrees.ItemFamilyTree;
import ru.gb.family.ItemFamilyTrees.enums.Gender;
import ru.gb.family.ItemFamilyTrees.enums.Сountries;

import java.time.LocalDate;


public class Human extends ItemFamilyTree {
    private Сountries сountry;

    public Human(String name, LocalDate birthday, LocalDate dateOfDeath, Gender gender, Сountries сountry) {
        super(name, birthday, dateOfDeath, gender);
        this.сountry = сountry;

    }
}
