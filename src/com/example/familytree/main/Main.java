package com.example.familytree.main;

import com.example.familytree.FamilyTree;
import com.example.familytree.model.Person;
import com.example.familytree.operations.FileFamilyTreeOperations;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Создание генеалогического древа
        FamilyTree familyTree = new FamilyTree();

        // Создание людей с использованием LocalDate для даты рождения
        Person anastasiya = new Person("Анастасия", LocalDate.of(1988, 3, 15), "Жен");
        Person mihail = new Person("Михаил", LocalDate.of(1983, 7, 22), "Муж");
        Person anton = new Person("Антон", LocalDate.of(2013, 1, 5), "Муж");
        Person diana = new Person("Диана", LocalDate.of(2015, 11, 30), "Жен");
        Person varvara = new Person("Варвара", LocalDate.of(1963, 5, 10), "Жен");
        Person nikola = new Person("Николай", LocalDate.of(1958, 9, 18), "Муж");

        // Установка родственных связей
        anastasiya.addChild(anton);
        anastasiya.addChild(diana);
        mihail.addChild(anton);
        mihail.addChild(diana);
        varvara.addChild(anastasiya);
        nikola.addChild(anastasiya);

        // Добавление людей в генеалогическое древо
        familyTree.addPerson(anastasiya);
        familyTree.addPerson(mihail);
        familyTree.addPerson(anton);
        familyTree.addPerson(diana);
        familyTree.addPerson(varvara);
        familyTree.addPerson(nikola);

        // Демонстрация дерева
        System.out.println("Фамильное древо:");
        familyTree.displayTree();

        // Сортировка по имени
        System.out.println("\nФамильное древо, отсортированное по имени:");
        familyTree.sortByName();
        familyTree.displayTree();

        // Сортировка по дате рождения
        System.out.println("\nФамильное древо, отсортированное по дате рождения:");
        familyTree.sortByBirthDate();
        familyTree.displayTree();

        // Создание объекта для операций с файлами
        FileFamilyTreeOperations fileOps = new FileFamilyTreeOperations();

        // Сохранение генеалогического древа в файл
        fileOps.saveToFile("family_tree.txt", familyTree);

        // Очистка текущего дерева для демонстрации загрузки
        familyTree = new FamilyTree();

        // Загрузка генеалогического древа из файла
        familyTree = fileOps.loadFromFile("family_tree.dat");

        // Демонстрация дерева после загрузки
        System.out.println("\nФамильное древо после загрузки из файла:");
        familyTree.displayTree();

        // Получение всех детей выбранного человека
        System.out.println("\nДети Анастасии:");
        for (Person child : familyTree.getChildrenOf("Анастасия")) {
            System.out.println(child);
        }

        // Пример поиска человека по имени
        System.out.println("\nНайти человека по имени 'Михаил':");
        Person foundPerson = familyTree.findPersonByName("Михаил");
        if (foundPerson != null) {
            System.out.println(foundPerson);
        } else {
            System.out.println("Человек не найден");
        }
    }
}
