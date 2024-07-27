package ru.gb.family_tree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        
        var backupFamilyTree = new FileHandler("object.bin");
        
        // Try restore familyTree object from local file system
        FamilyTree familyTree = backupFamilyTree.readObject();

        if (familyTree == null) {
        
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

            familyTree = new FamilyTree();
            familyTree.addMember(father);
            familyTree.addMember(mother);
            familyTree.addMember(child1);
            familyTree.addMember(child2);
        }

        Human foundFather = familyTree.findByFullName("John Michael Doe");
        if (foundFather != null) {
            FamilyTree childrenTree = familyTree.getChildren(foundFather);
            System.out.println("Children and descendants of " + foundFather.getFullName() + ":");
            System.out.println(childrenTree);
        } else {
            System.out.println("Father not found.");
        }

        System.out.println("\n");
        System.out.println("Full family tree:");
        System.out.println(familyTree);
        
        // Save familyTree object to local file system
        backupFamilyTree.writeObject(familyTree);
    }
}