package ru.gb.family_tree;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
    FamilyTree tree = new FamilyTree();

    Human fyodor = new Human("Фёдор", Gender.Male, LocalDate.of(1956, 8, 15));
    Human vera = new Human("Вера", Gender.Female, LocalDate.of(1961, 6, 19));

    tree.addHuman(fyodor);
    tree.addHuman(vera);
    tree.setWedding(fyodor, vera);

    Human irina = new Human("Ирина", Gender.Female, LocalDate.of(1969, 7, 7), fyodor, vera);
    Human natasha = new Human("Наташа", Gender.Female, LocalDate.of(1972, 5, 21), fyodor, vera);
    Human yulya = new Human("Юля", Gender.Female, LocalDate.of(1975, 12, 14), fyodor, vera);

    tree.addHuman(irina);
    tree.addHuman(natasha);
    tree.addHuman(yulya);

    System.out.println(tree);

    tree.remove(natasha.getId());

    System.out.println(tree);

    fyodor.addChild(irina);
    fyodor.addChild(yulya);
    vera.addChild(yulya);
    vera.addChild(yulya);
    vera.addChild(yulya);

    tree.setDivorce(fyodor, vera);


    writeTree(tree);
    System.out.println(tree);

    readTree(tree);

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
