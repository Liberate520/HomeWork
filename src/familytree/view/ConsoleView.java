package familytree.view;

import familytree.model.Person;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ConsoleView {
    private Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("\n--- Family Tree Menu ---");
        System.out.println("1. Add person");
        System.out.println("2. Show all people");
        System.out.println("3. Find person's children");
        System.out.println("4. Sort by name");
        System.out.println("5. Sort by birth date");
        System.out.println("6. Save to file");
        System.out.println("7. Load from file");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    public int getUserChoice() {
        return scanner.nextInt();
    }

    public String getPersonName() {
        System.out.print("Enter name: ");
        return scanner.next();
    }

    public LocalDate getPersonBirthDate() {
        System.out.print("Enter birth date (YYYY-MM-DD): ");
        return LocalDate.parse(scanner.next());
    }

    public String getPersonGender() {
        System.out.print("Enter gender (MALE/FEMALE): ");
        return scanner.next().toUpperCase();
    }

    public void showPeople(List<Person> people) {
        for (Person person : people) {
            System.out.println(person.getName() + " - " + person.getBirthDate() + " - " + person.getGender());
        }
    }

    public void showChildren(List<Person> children) {
        if (children.isEmpty()) {
            System.out.println("No children found.");
        } else {
            System.out.println("Children:");
            showPeople(children);
        }
    }

    public String getFileName() {
        System.out.print("Enter file name: ");
        return scanner.next();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}