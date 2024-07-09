package ru.gb.family_tree;

import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Gender;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Human father = new Human("John", "Doe", LocalDate.of(1960, 5, 15),
                null, Gender.Male, null, null);
        Human mother = new Human("Jane", "Doe", LocalDate.of(1970, 8, 20),
                null, Gender.Female, null, null);

        Human child1 = new Human("Alice", "Doe", LocalDate.of(1990, 2, 10),
                null, Gender.Female, father, mother);
        father.addChild(child1);
        mother.addChild(child1);

        Human child2 = new Human("Bob", "Doe", LocalDate.of(1995, 11, 30),
                null, Gender.Male, father, mother);
        father.addChild(child2);
        mother.addChild(child2);

        FamilyTree familyTree = new FamilyTree();
        familyTree.addHuman(father);
        familyTree.addHuman(mother);

        Human foundPerson = familyTree.findPersonByName("Alice", "Doe");
        if (foundPerson != null) {
            foundPerson.printParents();
            foundPerson.printChildren();
        }

        father.printChildren();
        mother.printChildren();
        child1.printParents();
        child2.printParents();
    }


}
