package ru.gb.family_tree;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        FamilyTree tree = testTree();

        FileHandler fileOps = new FileHandler(new FamilyTree());

        try {
            fileOps.saveToFile("family_tree.out");
            System.out.println("Семейное древо сохранено в файл");

            fileOps.loadFromFile("family_tree.out");
            System.out.println("Семейное древо загружено из файла");

        } catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }

        System.out.println(tree);
        tree.sortByBirthDate();
        System.out.println(tree);
        tree.sortByName();
        System.out.println(tree);
    }

    private static FamilyTree testTree(){
        FamilyTree tree = new FamilyTree();

        Human nikolay = new Human("Николай", Gender.Male, LocalDate.of(1963, 3, 26 ));
        Human nadezhda = new Human("Надежда", Gender.Female, LocalDate.of(1961, 11, 13));

        tree.add(nikolay);
        tree.add(nadezhda);
        tree.setWedding(nikolay, nadezhda);

        Human anton = new Human("Антон", Gender.Male, LocalDate.of(1985, 7, 21), nikolay, nadezhda);
        tree.add(anton);

        Human grandMother = new Human("Валентина", Gender.Female, LocalDate.of(1945, 9, 1));
        grandMother.addChild(nikolay);

        Human grandMother1 = new Human("Мария", Gender.Female, LocalDate.of(1940, 10, 12));
        grandMother1.addChild(nadezhda);

        tree.add(grandMother);
        tree.add(grandMother1);
        return tree;
    }
}
