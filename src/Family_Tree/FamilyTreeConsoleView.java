package Family_Tree;

import java.time.LocalDate;
import java.util.Scanner;

public class FamilyTreeConsoleView {
    private FamilyTree model;
    private Scanner scanner;

    public FamilyTreeConsoleView(FamilyTree model) {
        this.model = model;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Welcome to Family Tree Console");

        while (true) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    displayTree();
                    break;
                case 3:
                    saveTreeToFile();
                    break;
                case 4:
                    loadTreeFromFile();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\
1. Add Person");
        System.out.println("2. Display Family Tree");
        System.out.println("3. Save Family Tree to File");
        System.out.println("4. Load Family Tree from File");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    private int getUserChoice() {
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline character
        return choice;
    }

    private void addPerson() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter gender (0 for Male, 1 for Female): ");
        int gender = scanner.nextInt();
        scanner.nextLine(); // consume newline character
        System.out.print("Enter birth date (yyyy-mm-dd): ");
        String birthDateStr = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(birthDateStr);

        Person person = new Person(name, gender, birthDate);
        model.addPerson(person);
        System.out.println("Person added successfully.");
    }

    private void displayTree() {
        System.out.println("\
Family Tree:");
        System.out.println(model.toString());
    }

    private void saveTreeToFile() {
        System.out.print("Enter file name to save: ");
        String fileName = scanner.nextLine();
        model.saveToFile(fileName);
        System.out.println("Family Tree saved to file: " + fileName);
    }

    private void loadTreeFromFile() {
        System.out.print("Enter file name to load: ");
        String fileName = scanner.nextLine();
        model.loadFromFile(fileName);
        System.out.println("Family Tree loaded from file: " + fileName);
    }
}