package family_tree;

import java.util.List;
import java.util.Scanner;

// Главный класс приложения для работы с генеалогическим деревом
public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        FileHandler fileHandler = new FileHandler();
        Scanner scanner = new Scanner(System.in);

        // Добавление людей в дерево
        familyTree.addHuman("Alice", "01-01-1970", "женский");
        familyTree.addHuman("Eugen", "21-08-1965", "мужской");
        familyTree.addHuman("Bob", "01-01-2000", "мужской");
        familyTree.addHuman("Charlie", "01-01-2005", "мужской");

// Установление родительско-детских отношений
        familyTree.addChild("Alice", "Bob");
        familyTree.addChild("Alice", "Charlie");
        familyTree.addChild("Eugen", "Bob");
        familyTree.addChild("Eugen", "Charlie");

        // Установка даты смерти
        familyTree.setDeathDate("Alice", "01-01-2020");

        // Установление супружеской связи
        familyTree.setSpouse("Alice", "Eugen");

        // Сохранение семейного дерева в файл
        fileHandler.saveFamilyTree(familyTree, "familyTree.dat");

        // Чтение семейного дерева из файла
        FamilyTree loadedFamilyTree = fileHandler.loadFamilyTree("familyTree.dat");

        if (loadedFamilyTree != null) {
            // Отображение всего генеалогического дерева
            System.out.println("\nПолное генеалогическое дерево:");
            System.out.println(loadedFamilyTree.displayFamilyTree());

            // Сортировка и отображение по дате рождения
            System.out.println("\nСортировка по дате рождения:");
            List<Human> sortedByBirthDate = loadedFamilyTree.sortByBirthDate();
            sortedByBirthDate.forEach(System.out::println);

            // Сортировка и отображение по идентификатору
            System.out.println("\nСортировка по идентификатору:");
            List<Human> sortedById = loadedFamilyTree.sortById();
            sortedById.forEach(System.out::println);

        }

        scanner.close();
    }
}



