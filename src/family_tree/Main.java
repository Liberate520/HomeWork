package ru.gb.family_tree;

import ru.gb.family_tree.family_tree.FamilyTree;
import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.service.FamilyTreeService;
import ru.gb.family_tree.writer.FileHandler;
import ru.gb.family_tree.writer.Writer;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Создание экземпляра генеалогического древа
        FamilyTree familyTree = new FamilyTree();
        FamilyTreeService familyTreeService = new FamilyTreeService(familyTree);

        // Создание и добавление людей в генеалогическое древо
        Human olga = new Human("Ольга", LocalDate.of(1945, 5, 15), Gender.Female, null, null);
        familyTreeService.addMember(olga);

        Human ivan = new Human("Иван", LocalDate.of(1963, 3, 10), Gender.Male, null, null);
        familyTreeService.addMember(ivan);

        // Устанавливаем супругов
        ivan.setSpouse(olga);
        olga.setSpouse(ivan);

        Human anna = new Human("Анна", LocalDate.of(1985, 7, 22), Gender.Female, ivan, olga);
        familyTreeService.addMember(anna);

        Human sergey = new Human("Сергей", LocalDate.of(1990, 11, 5), Gender.Male, ivan, olga);
        familyTreeService.addMember(sergey);

        // Добавляем детей к родителям
        olga.addChild(anna);
        olga.addChild(sergey);
        ivan.addChild(anna);
        ivan.addChild(sergey);

        // Сортировка по имени и вывод результата
        familyTreeService.sortByName();
        System.out.println("Сортировка по имени:");
        for (Human member : familyTreeService.getMembers()) {
            System.out.println(member);
        }

        // Сортировка по количеству детей и вывод результата
        familyTreeService.sortByChildrenCount();
        System.out.println("\nСортировка по количеству детей:");
        for (Human member : familyTreeService.getMembers()) {
            System.out.println(member);
        }

        // Работа с файлом
        Writer fileHandler = new FileHandler();
        fileHandler.setPath("family_tree.ser");
        fileHandler.save(familyTree);

        FamilyTree loadedTree = (FamilyTree) fileHandler.read();
        if (loadedTree != null) {
            System.out.println("\nЗагруженное дерево:");
            for (Human member : loadedTree.getMembers()) {
                System.out.println(member);
            }
        } else {
            System.out.println("\nОшибка загрузки дерева.");
        }
    }
}
