package ru.gb.family.familyTree.ItemFamilyTrees.cat;

import ru.gb.family.familyTree.ItemFamilyTrees.ItemFamilyTree;
import ru.gb.family.familyTree.ItemFamilyTrees.enums.Gender;

import java.time.LocalDate;

public class Cat extends ItemFamilyTree {
    private String color;

    public Cat(long id,String name, LocalDate birthday, Gender gender) {
        super(id,name, birthday,gender);
    }
}
