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
        familyTree.setDeathDate("Alice", "01-01-2024");

        // Установление супружеской связи
        familyTree.setSpouse("Alice", "Eugen");

        // Сохранение семейного дерева в файл
        fileHandler.saveFamilyTree(familyTree, "familyTree.dat");

        // Сохранение семейного дерева в текстовый файл
        fileHandler.saveFamilyTreeAsText(familyTree, "familyTree.txt");

        // Чтение семейного дерева из файла
        FamilyTree loadedFamilyTree = fileHandler.loadFamilyTree("familyTree.dat");

        // Исследование: получение детей определенного человека
        System.out.println("Введите имя человека, чтобы найти его детей:");
        String name = scanner.nextLine();

        List<Human> children = loadedFamilyTree.getChildren(name);
        if (children != null) {
            System.out.println("Дети " + name + ":");
            for (Human child : children) {
                System.out.println("- " + child.getName());
            }
        } else {
            System.out.println(name + " не имеет детей или не существует в генеалогическом дереве.");
        }

        // Отображение всего генеалогического дерева
        System.out.println("\nПолное генеалогическое дерево:");
        System.out.println(loadedFamilyTree.displayFamilyTree());

        scanner.close();
    }
}


