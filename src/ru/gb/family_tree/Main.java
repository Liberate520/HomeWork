package ru.gb.family_tree;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Human me = new Human("Peter", "Ryzhov",
                LocalDate.of(1981, 12, 14));

        FamilyTree familyTree = new FamilyTree();

        familyTree.add(me);

        System.out.println(me);
    }
}