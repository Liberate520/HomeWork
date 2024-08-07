package ru.gb.family_tree;

import java.io.IOException;
import java.time.LocalDate;
import ru.gb.family_tree.serializers.FileHandler;
import ru.gb.family_tree.serializers.PersistenceHandler;

public class Main {
    public static void main(String[] args) {
        PersistenceHandler<FamilyTree<Human>> backupFamilyTree = new FileHandler<>("object.bin");

        FamilyTree<Human> familyTree;
        try {
            // Try to restore familyTree object from local file system
            familyTree = backupFamilyTree.readObject();
        } catch (IOException | ClassNotFoundException e) {
            // Initialize a new family tree if reading fails
            familyTree = new FamilyTree<>();
        }

        if (familyTree.getMembers().isEmpty()) {
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

            familyTree.addMember(father);
            familyTree.addMember(mother);
            familyTree.addMember(child1);
            familyTree.addMember(child2);
        }

        Human foundFather = familyTree.findByFullName("John Michael Doe");
        if (foundFather != null) {
            FamilyTree<Human> childrenTree = familyTree.getChildren(foundFather);
            System.out.println("Children and descendants of " + foundFather.getFullName() + ":");
            System.out.println(childrenTree);
        } else {
            System.out.println("Father not found.");
        }

        System.out.println("\nFull family tree:");
        System.out.println(familyTree);

        // Сортировка и вывод списка членов семьи
        System.out.println("\nSorted by name:");
        familyTree.sortByName();
        System.out.println(familyTree);

        System.out.println("\nSorted by birth date:");
        familyTree.sortByBirthDate();
        System.out.println(familyTree);

        try {
            // Save familyTree object to local file system
            backupFamilyTree.writeObject(familyTree);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
