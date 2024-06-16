package main;

import model.Person;
import service.FamilyTreeService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.io.IOException;

public class CommandProcessor {
    private FamilyTreeService service;
    private Scanner scanner;
    private Map<String, Runnable> commandMap;

    public CommandProcessor(FamilyTreeService service) {
        this.service = service;
        this.scanner = new Scanner(System.in);
        initializeCommands();
    }

    private void initializeCommands() {
        commandMap = new HashMap<>();
        commandMap.put("add", this::addMember);
        commandMap.put("find", this::findMember);
        commandMap.put("children", this::getChildrenOf);
        commandMap.put("exit", () -> System.exit(0));
    }

    public void start() {
        while (true) {
            System.out.println("Введите команду (add/find/children/exit):");
            String command = scanner.nextLine();
            Runnable action = commandMap.get(command);

            if (action != null) {
                action.run();
            } else {
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






