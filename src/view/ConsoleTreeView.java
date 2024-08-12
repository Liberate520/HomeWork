package view;

import person.Person;
import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleTreeView implements TreeView {
    private Presenter presenter;
    private Scanner scanner;

    public ConsoleTreeView() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayPerson(Person person) {
        if (person != null) {
            System.out.println("Person found: " + person);
        } else {
            System.out.println("Person not found.");
        }
    }

    @Override
    public void displayAllPersons(String persons) {
        System.out.println(persons);
    }

    @Override
    public String getUserInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void start() {
        while (true) {
            System.out.println("\n1. Add Person");
            System.out.println("2. Find Person");
            System.out.println("3. List all members");
            System.out.println("4. Sort by Name");
            System.out.println("5. Sort by Birth Date");
            System.out.println("6. Exit");

            String choice = getUserInput("Choose an option: ");

            switch (choice) {
                case "1":
                    addPerson();
                    break;
                case "2":
                    findPerson();
                    break;
                case "3":
                    presenter.displayAllPersons();
                    break;
                case "4":
                    presenter.sortByName();
                    presenter.displayAllPersons();
                    break;
                case "5":
                    presenter.sortByBirthDate();
                    presenter.displayAllPersons();
                    break;
                case "6":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addPerson() {
        String name = getUserInput("Enter name: ");
        LocalDate birthDate = LocalDate.parse(getUserInput("Enter birth date (YYYY-MM-DD): "));
        String deathDateStr = getUserInput("Enter death date (YYYY-MM-DD) or leave blank if alive: ");
        LocalDate deathDate = deathDateStr.isEmpty() ? null : LocalDate.parse(deathDateStr);
        String gender = getUserInput("Enter gender (MALE/FEMALE): ");

        presenter.addPerson(name, birthDate, deathDate, gender);
    }

    private void findPerson() {
        String name = getUserInput("Enter name: ");
        presenter.findPerson(name);
    }
}
