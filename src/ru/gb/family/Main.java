package ru.gb.family;

import ru.gb.family.human.Gender;
import ru.gb.family.human.Human;
import ru.gb.family.tree.FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        Human adam = new Human("Adam", Gender.Male, LocalDate.of(1976, 2, 1));
        Human eva = new Human("Eva", Gender.Female, LocalDate.of(1973, 5, 10));
        tree.add(adam);
        tree.add(eva);
        tree.setWedding(adam, eva);

        Human sonya = new Human("Sonya", Gender.Female, LocalDate.of(1995, 6, 9), adam, eva);
        Human gleb = new Human("Gleb", Gender.Male, LocalDate.of(1993, 8, 12), adam, eva);

        tree.add(sonya);
        tree.add(gleb);

        Human grandMother = new Human("Olga", Gender.Female, LocalDate.of(1973, 8, 7));
        grandMother.addChild(adam);

        tree.add(grandMother);


        System.out.println(tree);
    }
}
