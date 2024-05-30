package com.familytree.main;

import com.familytree.io.FileHandler;
import com.familytree.model.FamilyTree;
import com.familytree.model.Gender;
import com.familytree.model.Human;
import com.familytree.utils.Writeable;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/tree.txt";
        FamilyTree tree;

        // Загружаем дерево из файла, если файл существует, иначе создаем тестовое дерево
        File file = new File(filePath);
        if (file.exists() && !file.isDirectory()) {
            tree = load(filePath);
            System.out.println("Дерево загружено из файла.");
        } else {
            tree = testTree();
            System.out.println("Создано тестовое дерево.");
        }
        System.out.println("Исходное дерево:");
        System.out.println(tree);

        tree.sortByName();
        System.out.println("Сортировка по имени:");
        System.out.println(tree);

        tree.sortByBirthDate();
        System.out.println("Сортировка по дате рождения:");
        System.out.println(tree);

        save(tree, filePath);
    }

    private static FamilyTree<Human> load(String filePath) {
        Writeable writeable = new FileHandler();
        try {
            return writeable.readFromFile(filePath);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new FamilyTree<>();
    }

    private static void save(FamilyTree<Human> tree, String filePath) {
        Writeable writeable = new FileHandler();
        try {
            writeable.writeToFile(tree, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static FamilyTree<Human> testTree() {
        FamilyTree<Human> tree = new FamilyTree<>();

        Human ruslan = new Human("Руслан", Gender.Male, LocalDate.of(1976, 11, 8),
                LocalDate.of(2017, 6, 7));
        Human elena = new Human("Елена", Gender.Female, LocalDate.of(1969, 12, 10));

        tree.add(ruslan);
        tree.add(elena);
        tree.setWedding(ruslan.getId(), elena.getId());

        Human liza = new Human("Лиза", Gender.Female, LocalDate.of(1998, 8, 19),
                ruslan, elena);
        Human nasty = new Human("Настя", Gender.Female, LocalDate.of(2002, 7, 11),
                ruslan, elena);

        tree.add(liza);
        tree.add(nasty);

        Human grandMother1 = new Human("Валентина", Gender.Female, LocalDate.of(1938, 4,
                20));
        Human grandMother2 = new Human("Бронислава", Gender.Female, LocalDate.of(1947, 4,
                12));
        grandMother1.addChild(elena);
        grandMother2.addChild(ruslan);

        tree.add(grandMother1);
        tree.add(grandMother2);

        Human grandFather1 = new Human("Иван", Gender.Male, LocalDate.of(1941, 8, 1),
                LocalDate.of(1991, 11, 16));
        Human grandFather2 = new Human("Анатолий", Gender.Male, LocalDate.of(1951, 8,
                2),
                LocalDate.of(2018, 7, 3));
        grandFather1.addChild(elena);
        grandFather2.addChild(ruslan);

        tree.add(grandFather1);
        tree.setWedding(grandFather1.getId(), grandMother1.getId());
        tree.add(grandFather2);
        tree.setWedding(grandFather2.getId(), grandMother2.getId());

        return tree;
    }
}

