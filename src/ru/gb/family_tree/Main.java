package ru.gb.family_tree;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;

import ru.gb.family_tree.writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree tree = getFamilyTree();

        writeTree(tree);
        tree.sortByName();
        System.out.println(tree);
        tree.sortByAge();
        System.out.println(tree);

        readTree(tree);

    }

    private static FamilyTree getFamilyTree() {
        FamilyTree tree = new FamilyTree();

        Human fyodor = (Human) tree.add("Фёдор", Gender.Male, LocalDate.of(1956, 8, 15));
        Human vera = (Human) tree.add("Вера", Gender.Female, LocalDate.of(1961, 6, 19));

        tree.setWedding(fyodor, vera);

        Human irina = (Human) tree.add("Ирина", Gender.Female, LocalDate.of(1969, 7, 7), fyodor, vera);
        Human natasha = (Human) tree.add("Наташа", Gender.Female, LocalDate.of(1972, 5, 21), fyodor, vera);
        Human yulya = (Human) tree.add("Юля", Gender.Female, LocalDate.of(1975, 12, 14), fyodor, vera);

        fyodor.addChild(irina);
        fyodor.addChild(yulya);
        fyodor.addChild(natasha);
        vera.addChild(yulya);
        vera.addChild(irina);
        vera.addChild(natasha);
        return tree;
    }

    private static void writeTree(FamilyTree tree) throws IOException {
        FileHandler fileHandler = new FileHandler();
        fileHandler.write(tree);
    }

    private static Object readTree(FamilyTree tree) throws IOException, ClassNotFoundException {
        FileHandler fileHandler = new FileHandler();
        return(FamilyTree) fileHandler.read();
    }

}
