package ru.gb.family_tree.main;

import ru.gb.family_tree.FamilyTree;
import ru.gb.family_tree.models.Human;
import ru.gb.family_tree.util.FileHandler;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Human> familyTree = new FamilyTree<>();
        FileHandler<Human> fileHandler = new FileHandler<>();

        // Добавление людей в дерево
        familyTree.addMember(new Human(1, "Alice", "01-01-1970", "женский"));
        familyTree.addMember(new Human(2, "Eugen", "21-08-1965", "мужской"));
        familyTree.addMember(new Human(3, "Bob", "01-01-2000", "мужской"));
        familyTree.addMember(new Human(4, "Charlie", "01-01-2005", "мужской"));

        // Установление родительско-детских отношений
        Human alice = familyTree.getMember(1);
        Human eugen = familyTree.getMember(2);
        Human bob = familyTree.getMember(3);
        Human charlie = familyTree.getMember(4);
        alice.addChild(bob);
        alice.addChild(charlie);
        eugen.addChild(bob);
        eugen.addChild(charlie);

        // Установление супружеской связи
        alice.setSpouse(eugen);
        eugen.setSpouse(alice);

        // Сохранение семейного дерева в файл
        String filename = "familyTree.ser";
        fileHandler.saveFamilyTree(familyTree, filename);

        // Загрузка семейного дерева из файла
        FamilyTree<Human> loadedFamilyTree = fileHandler.loadFamilyTree(filename);

        if (loadedFamilyTree != null) {
            // Отображение всего генеалогического дерева
            System.out.println("\nПолное генеалогическое дерево:");
            loadedFamilyTree.getAllMembers().forEach(System.out::println);

            // Сортировка и отображение по дате рождения
            System.out.println("\nСортировка по дате рождения:");
            loadedFamilyTree.sortBy(Comparator.comparing(Human::getBirthDate))
                    .forEach(System.out::println);

            // Сортировка и отображение по идентификатору
            System.out.println("\nСортировка по идентификатору:");
            loadedFamilyTree.sortBy(Comparator.comparing(Human::getId))
                    .forEach(System.out::println);
        }
    }
}
