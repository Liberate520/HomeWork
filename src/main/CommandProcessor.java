package main;

import model.Person;
import service.FamilyTreeService;
import java.util.Scanner;
import java.io.IOException;
import java.util.List;

public class CommandProcessor {
    private FamilyTreeService service;
    private Scanner scanner;

    public CommandProcessor(FamilyTreeService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("Введите команду (add/find/children/exit):");
            String command = scanner.nextLine();

            switch (command) {
                case "add":
                    addMember();
                    break;
                case "find":
                    findMember();
                    break;
                case "children":
                    getChildrenOf();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Неизвестная команда.");
            }
        }
    }

    private void addMember() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();
        System.out.println("Введите возраст:");
        int age = Integer.parseInt(scanner.nextLine());

        Person person = new Person(name, age);
        service.addMember(person);
        System.out.println("Член добавлен: " + person);
        saveFamilyTree();
    }

    private void findMember() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();

        Person person = service.findPersonByName(name);
        if (person != null) {
            System.out.println("Найден: " + person);
        } else {
            System.out.println("Человек не найден.");
        }
    }

    private void getChildrenOf() {
        System.out.println("Введите имя родителя:");
        String name = scanner.nextLine();
        Person parent = service.findPersonByName(name);
        if (parent != null) {
            List<Person> children = service.getChildrenOf(parent);
            displayChildren(children);
        } else {
            System.out.println("Человек не найден.");
        }
    }

    private void displayChildren(List<Person> children) {
        System.out.println("Дети:");
        for (Person child : children) {
            System.out.println(child);
        }
    }

    private void saveFamilyTree() {
        try {
            service.saveFamilyTree();
        } catch (IOException e) {
            System.out.println("Ошибка сохранения семейного дерева: " + e.getMessage());
        }
    }
}





