package main;

import model.FamilyTree;
import model.Person;

import java.util.List;
import java.util.Scanner;

public class CommandProcessor {
    private FamilyTree<Person> familyTree;
    private Scanner scanner;

    public CommandProcessor(FamilyTree<Person> familyTree) {
        this.familyTree = familyTree;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("Enter command (add/find/exit):");
            String command = scanner.nextLine();

            switch (command) {
                case "add":
                    addMember();
                    break;
                case "find":
                    findMember();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Unknown command.");
            }
        }
    }

    private void addMember() {
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter age:");
        int age = Integer.parseInt(scanner.nextLine());

        Person person = new Person(name, age);
        familyTree.addMember(person);
    }

    private void findMember() {
        System.out.println("Enter name:");
        String name = scanner.nextLine();

        Person person = (Person) familyTree.findPersonByName(name);
        if (person != null) {
            System.out.println("Found: " + person);
        } else {
            System.out.println("Person not found.");
        }
    }
}
