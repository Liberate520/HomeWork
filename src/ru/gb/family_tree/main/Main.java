package ru.gb.family_tree.main;

import ru.gb.family_tree.model.*;
import ru.gb.family_tree.util.FileManager;
import java.time.LocalDate;
//import java.util.List;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = testTree();
        System.out.println(tree);

        // Сортировка по имени
        tree.sortByName();
        System.out.println("Отсортировано по имени:");
        System.out.println(tree);

        // Сортировка по дате рождения
        tree.sortByBirthDate();
        System.out.println("Отсортировано по дате рождения:");
        System.out.println(tree);

        // Сохранение дерева в файл
        FileManager.writeToFile("family_tree.txt", tree);

        // Чтение дерева из файла
        FamilyTree loadedTree = (FamilyTree) FileManager.readFromFile("family_tree.txt");
        if (loadedTree != null) {
            System.out.println("\nДрево успешно загружено из файла:");
            System.out.println(loadedTree);
        }
    }

    private static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();

        Human sveta = new Human("Светлана", "Поджидаева", LocalDate.of(1937, 2, 13), Gender.Female);
        Human evgeny = new Human("Евгений", "Поджидаев", LocalDate.of(1936, 1, 12), Gender.Male);
        tree.add(sveta);
        tree.add(evgeny);
        Human ira = new Human("Ирина", "Поджидаева", LocalDate.of(1963, 8, 30), Gender.Female, sveta, evgeny);
        Human tanya = new Human("Татьяна", "Поджидаева", LocalDate.of(1970, 5, 5), Gender.Female, sveta, evgeny);
        tree.add(ira);
        tree.add(tanya);
        Human andr = new Human("Андрей", "Авдошин", LocalDate.of(1996, 8,30), Gender.Male, tanya, null);
        tree.add(andr);

        return tree;
    }
}
