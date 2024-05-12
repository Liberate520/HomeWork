package ru.gb.famile_tree;


import ru.gb.famile_tree.FamileTree.FamileTree;
import ru.gb.famile_tree.Human.Human;

import java.io.Serializable;
import java.time.LocalDate;


public class Main {
    public static void main(String[] args) {
        FamileTree tree = new FamileTree();

        // Добавление людей в древо с указанием дат рождения и смерти
        tree.addHuman("Анна", LocalDate.of(1913, 3, 7), LocalDate.of(2011, 10, 2), null);
        tree.addHuman("Семен", LocalDate.of(1912, 8, 25), LocalDate.of(1973, 3, 15), null  );
        tree.addHuman("Евгений", LocalDate.of(1936, 1, 12), null, "Семен");
        tree.addHuman("Светлана", LocalDate.of(1937, 2, 13), null, "Анна");
        tree.addHuman("Ирина", LocalDate.of(1963, 8, 30), null, "Светлана");
        tree.addHuman("Татьяна", LocalDate.of(1970, 5, 5), null, "Светлана");
        tree.addHuman("Андрей", LocalDate.of(1996, 8, 30), null, "Татьяна");

        // Сохранение дерева в файл
        FileManager.writeToFile("famile_tree.ser", (Serializable) tree);

        // Чтение дерева из файла
       FamileTree loadedTree = (FamileTree) FileManager.readFromFile("famile_tree.ser");
        if (loadedTree != null) {
            System.out.println("\nДрево успешно загружено из файла");
    //                loadedTree.printTree();
                    tree = loadedTree;
        }

        // Вывод на экран древа
        System.out.println("Генеалогическое древо:");
        tree.printTree();

        // Поиск человека
        String nameToFind = "Татьяна";
        Human humanFound = tree.findHuman(nameToFind);
        if (humanFound != null) {
            System.out.println("\n" + nameToFind + " найден в генеалогическом древе.");
        } else {
            System.out.println("\n" + nameToFind + " не найден в генеалогическом древе.");
        }

    }
}