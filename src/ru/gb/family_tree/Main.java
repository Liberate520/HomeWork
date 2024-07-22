package ru.gb.family_tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Human father = new Human("John", Gender.Male, LocalDate.of(1975, 5, 20), null, null);
        Human mother = new Human("Jane", Gender.Female, LocalDate.of(1978, 8, 15), null, null);
        Human child1 = new Human("Alice", Gender.Female, LocalDate.of(2000, 3, 30), mother, father);
        Human child2 = new Human("Bob", Gender.Male, LocalDate.of(2002, 7, 10), mother, father);

        father.addChild(child1);
        father.addChild(child2);
        mother.addChild(child1);
        mother.addChild(child2);

        FamilyTree familyTree = new FamilyTree();
        familyTree.addMember(father);
        familyTree.addMember(mother);
        familyTree.addMember(child1);
        familyTree.addMember(child2);

        Human foundFather = familyTree.findByName("John");
        if (foundFather != null) {
            List<Human> children = familyTree.getChildren(foundFather);
            System.out.println("Children of " + foundFather.getName() + ":");
            for (Human child : children) {
                System.out.println(child.getName());
            }
        } else {
            System.out.println("Father not found.");
        }
    }
}
