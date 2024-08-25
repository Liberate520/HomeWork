package Homework4_OOP;

import Homework4_OOP.FamilyTrees.FamilyTree;
import Homework4_OOP.Human.Gender;
import Homework4_OOP.Human.Human;
import Homework4_OOP.WritersClasses.FileHandler;
import Homework4_OOP.WritersClasses.UserInterface;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        FamilyTree<Human> tree = load("save.txt");
        if (tree == null) {
            tree = famTree();
        }
        UserInterface ui = new UserInterface(tree);
        ui.start();
        save(tree, "save.txt");

        System.out.println("Сортировка по имени:");
        tree.sortByName();
        for (Human human : tree) {
            System.out.println(human);
        }

        System.out.println("\nСортировка по дате рождения:");
        tree.sortByBirthDate();
        for (Human human : tree) {
            System.out.println(human);
        }
    }

    private static FamilyTree<Human> load(String filename) {
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree<Human>) fileHandler.read(filename);
    }

    private static void save(FamilyTree<Human> familyTree, String filename) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree, filename);
    }

    private static FamilyTree<Human> famTree() {
        FamilyTree<Human> tree = new FamilyTree<>();

        Human first = new Human("Aleks", Gender.Male, LocalDate.of(1985, 1, 19));
        Human second = new Human("Marina", Gender.Female, LocalDate.of(1996, 10, 30));

        tree.add(first);
        tree.add(second);
        tree.setWedding(first, second);

        Human child1 = new Human("Dmitry", Gender.Male, LocalDate.of(2008, 1, 10), first, second);

        tree.add(child1);
        return tree;
    }
}
