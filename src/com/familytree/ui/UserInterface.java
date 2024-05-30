
package com.familytree.ui;

import com.familytree.model.FamilyTree;
import com.familytree.model.Human;
import com.familytree.model.Gender;

import java.time.LocalDate;
import java.util.Scanner;

public class UserInterface {
    private final FamilyTree<Human> familyTree;
    private final Scanner scanner;

    public UserInterface(FamilyTree<Human> familyTree) {
        this.familyTree = familyTree;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            showMenu();
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    addHuman();
                    break;
                case "2":
                    displayTree();
                    break;
                case "3":
                    sortByName();
                    break;
                case "4":
                    sortByBirthDate();
                    break;
                case "5":
                    System.out.println("Выход из программы.");
                    return;
                default:
                    System.out.println("Неверная команда.");
                    break;
            }
        }
    }

    private void showMenu() {
        System.out.println("Выберите команду:");
        System.out.println("1. Добавить человека");
        System.out.println("2. Показать дерево");
        System.out.println("3. Сортировать по имени");
        System.out.println("4. Сортировать по дате рождения");
        System.out.println("5. Выход");
    }

    private void addHuman() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите пол (Male/Female): ");
        Gender gender = Gender.valueOf(scanner.nextLine());
        System.out.print("Введите дату рождения (yyyy-MM-dd): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());
        Human human = new Human(name, gender, birthDate);
        familyTree.add(human);
        System.out.println("Человек добавлен.");
    }

    private void displayTree() {
        System.out.println("Дерево:");
        System.out.println(familyTree);
    }

    private void sortByName() {
        familyTree.sortByName();
        System.out.println("Дерево отсортировано по имени.");
    }

    private void sortByBirthDate() {
        familyTree.sortByBirthDate();
        System.out.println("Дерево отсортировано по дате рождения.");
    }
}