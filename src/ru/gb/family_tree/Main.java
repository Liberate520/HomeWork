package ru.gb.family_tree;

import ru.gb.family_tree.familly_tree.FamilyTree;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import java.time.LocalDate;


public class Main {

    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Human maksim = new Human("Максим", LocalDate.of(1972,11, 22), Gender.Female);
        Human nataly = new Human("Наталья", LocalDate.of(1972,4, 9), Gender.Female);
        familyTree.add(maksim);
        familyTree.add(nataly);
        familyTree.setWedding(maksim, nataly); // женимся

        Human sasha = new Human("Александр", LocalDate.of(1994, 2, 24), Gender.Male,  maksim, nataly);
        familyTree.add(sasha);
        sasha.setFather(maksim);
        sasha.setMother(nataly);

        Human vova = new Human("Владимир", LocalDate.of(1994, 2, 24), Gender.Male,  maksim, nataly);
        familyTree.add(vova);
        vova.setFather(maksim);
        vova.setMother(nataly);

        Human grandMother = new Human("Людмила", LocalDate.of(1939, 12, 25), Gender.Female);
        familyTree.add(grandMother);
        maksim.setMother(grandMother); //

        Human sosed = new Human("Алекс", LocalDate.of(1990, 1, 1), Gender.Male);
        Human sosedka = new Human("Света", LocalDate.of(1991, 10, 10), Gender.Female);
        familyTree.add(sosed);
        familyTree.add(sosedka);
        familyTree.setWedding(sosed, sosedka); // женимся

        System.out.println(familyTree); // смотрим, что введено в Базу

        familyTree.setDivorce(sosed, sosedka);

        System.out.println(familyTree); // смотрим, что сосед развелся с соседкой

        System.out.println(sosed);
        familyTree.remove(5);
        familyTree.remove(6);

        System.out.println(familyTree); // удалил соседей из своего дерева
        System.out.println(sosed); // но в базе Human сосед есть

    }
}
