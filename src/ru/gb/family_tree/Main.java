package ru.gb.family_tree;


import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.writer.FileHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDate;


//public class Main {
//    public static void main(String[] args) {
//        FamilyTree tree = testTree();
//        System.out.println(tree);
//    }
public class Main {
    final static String filePath = "src/ru/gb/family_tree/writer/tree.txt";
    public static void main(String[] args) throws IOException, FileNotFoundException {
//        FamilyTree tree = load();
        FamilyTree tree = testTree();
        save(tree);

        System.out.println(tree);
    }

    private static FamilyTree load () {
        FileHandler fileHandler = new FileHandler(filePath);
        return (FamilyTree) fileHandler.read();
    }

    private static void save(FamilyTree familyTree) {
        FileHandler fileHandler = new FileHandler(filePath);
        fileHandler.save(familyTree);
    }

    private static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();

        Human vasya = new Human("Vasiliy", Gender.Male, LocalDate.of(1979, 11, 16));
        Human masha = new Human("Mariane", Gender.Female, LocalDate.of(1986, 5, 5));

        tree.add(vasya);
        tree.add(masha);
        tree.setWedding(vasya, masha);

        Human lena = new Human("Elena", Gender.Female, LocalDate.of(2009, 12, 12), vasya, masha);
        Human roma = new Human("Roman", Gender.Male, LocalDate.of(2005, 9, 23), vasya, masha);
        tree.add(lena);
        tree.add(roma);

        Human grandMother = new Human("Larissa", Gender.Female, LocalDate.of(1950, 07, 8));
        grandMother.addChild(vasya);

        tree.add(grandMother);

        Human grandFather = new Human("Petr", Gender.Male, LocalDate.of(1945, 12, 31));
        grandFather.addChild(vasya);

        tree.add(grandFather);

        return tree;
    }
}
