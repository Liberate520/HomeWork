package ru.gb.family_tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Human father = new Human(LocalDate.of(1975, 5, 20), "John", "Michael", "Doe", Gender.Male, 
                                  Nationality.AU, "Sydney", null, null, null);
        Human mother = new Human(LocalDate.of(1978, 8, 15), "Jane", "Elizabeth", "Smith", Gender.Female, 
                                  Nationality.AU, "Melbourne", null, null, null);
        Human child1 = new Human(LocalDate.of(2000, 3, 30), "Alice", "Marie", "Doe", Gender.Female, 
                                  Nationality.AU, "Sydney", mother, father, null);
        Human child2 = new Human(LocalDate.of(2002, 7, 10), "Bob", "John", "Doe", Gender.Male, 
                                  Nationality.AU, "Sydney", mother, father, null);

        father.addChild(child1);
        father.addChild(child2);
        mother.addChild(child1);
        mother.addChild(child2);

        FamilyTree familyTree = new FamilyTree();
        familyTree.addMember(father);
        familyTree.addMember(mother);
        familyTree.addMember(child1);
        familyTree.addMember(child2);

        Human foundFather = familyTree.findByFullName("John Michael Doe");
        if (foundFather != null) {
            List<Human> children = familyTree.getChildren(foundFather);
            System.out.println("Children of " + foundFather.getFullName() + ":");
            for (Human child : children) {
                System.out.println(child.getFullName());
            }
        } else {
            System.out.println("Father not found.");
        }
    }
}
