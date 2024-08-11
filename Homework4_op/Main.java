package Homework4_op;

import java.time.LocalDate;

import Handler.FileHandler;
import Human.Gender;
import Human.Human;

public class Main{

    public static void main(String[] args) { 

        FamilyTree tree = famTree();
        tree.sortByName();
        System.out.println(tree);

    }

    private static FamilyTree load() {
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read();
    }

    private static void save(FamilyTree familyTree){
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(familyTree);
    }

    private static FamilyTree famTree() {
        FamilyTree tree = new FamilyTree();

        Human first = new Human ("Altair", Gender.Male, LocalDate.of(1975, 2, 14));
        Human second = new Human ("Jasmine", Gender.Female, LocalDate.of(1976, 3, 11));

        tree.add(first);
        tree.add(second);
        tree.setWedding(first, second);

        Human child1 = new Human ("Balian", Gender.Male, LocalDate.of(2000, 1, 23), first, second);

        tree.add(child1);
        return tree;
    }
}
