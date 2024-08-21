package Homework4_OOP.WritersClasses;

import Homework4_OOP.FamilyTrees.FamilyTree;
import Homework4_OOP.Human.Gender;
import Homework4_OOP.Human.Human;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private final FamilyTree<Human> tree;
    private final Scanner scanner;

    public UserInterface(FamilyTree<Human> tree) {
        this.tree = tree;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            printMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> addHuman();
                case 2 -> searchByName();
                case 3 -> removeById();
                case 4 -> printTree();
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private void printMenu() {
        System.out.println("1- Добавить человека");
        System.out.println("2- Поиск по имени");
        System.out.println("3- Удаление по ID");
        System.out.println("4- Вывод Древа");
        System.out.println("5- Выход");
        System.out.print("Выберите из предложенного: ");
    }

    private void addHuman() {
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Выберете пол человека: ");
        String gender = scanner.nextLine();
        System.out.print("Введите год рождения (yyyy-mm-dd): ");
        String birthDateStr = scanner.nextLine();

        Human human = new Human(name, Gender.valueOf(gender), LocalDate.parse(birthDateStr));
        tree.add(human);
        System.out.println("Вы добавили человека");
    }

    private void searchByName() {
        System.out.print("Введите имя для поиска: ");
        String name = scanner.nextLine();
        List<Human> results = tree.getByName(name);
        if (results.isEmpty()) {
            System.out.println("Человека с таким именем не найдено: " + name);
        } else {
            results.forEach(System.out::println);
        }
    }

    private void removeById() {
        System.out.print("Введите ID: ");
        long id = scanner.nextLong();
        boolean result = tree.remove(id);
        if (result) {
            System.out.println("Вы удалили человека");
        } else {
            System.out.println("Человека с таким ID нет: " + id);
        }
    }

    private void printTree() {
        System.out.println(tree);
    }
}
