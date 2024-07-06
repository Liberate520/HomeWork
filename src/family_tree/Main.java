package family_tree;

import family_tree.human.Gender;
import family_tree.human.Human;
import java.time.LocalDate;

import family_tree.vending_tree.FamilyTree;
import family_tree.writer.FileHandler;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = readTree();
        saveTree(tree);
        System.out.println(tree);
    }

    private static FamilyTree readTree() {
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.read();
    }

    private static void saveTree(FamilyTree tree) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.save(tree);
    }

    private static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();
        Human vasya = new Human("Василий", Gender.Male, LocalDate.of(1963, 12, 18));
        Human masha = new Human("Мария", Gender.Female, LocalDate.of(1965, 9, 15));

        tree.add(vasya);
        tree.add(masha);
        tree.setWedding(vasya, masha);

        Human christina = new Human("Кристина", Gender.Female, LocalDate.of(1988, 7, 5), vasya, masha);
        Human semiyon = new Human("Семён", Gender.Male, LocalDate.of(1991, 1, 25), vasya, masha);

        tree.add(christina);
        tree.add(semiyon);

        Human grandMother = new Human("Лариса", Gender.Female, LocalDate.of(1945, 9, 1));
        grandMother.addChild(vasya);

        tree.add(grandMother);
        return tree;
    }
}