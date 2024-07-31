package Family_Tree;

import java.time.LocalDate;
import java.util.Scanner;

public class FamilyTreeConsole {
    private static final Scanner scanner = new Scanner(System.in);
    private static final FamilyTree tree = new FamilyTree(); // Исправлено на FamilyTree

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("Choose an option:");
            System.out.println("1. Add person");
            System.out.println("2. Find person");
            System.out.println("3. Save tree to file");
            System.out.println("4. Load tree from file");
            System.out.println("5. Print tree");
            System.out.println("6. Exit");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    findPerson();
                    break;
                case 3:
                    saveTree();
                    break;
                case 4:
                    loadTree();
                    break;
                case 5:
                    printTree();
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.outInvalid option. Please choose again.");
            }
        }
    }

    private static void addPerson() {
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter gender (0 for Male, 1 for Female):");
        int gender = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Enter birth year:");
        int year = scanner.nextInt();
        System.out.println("Enter birth month:");
        int month = scanner.nextInt();
        System.out.println("Enter birth day:");
        int day = scanner.nextInt();
        LocalDate birthDate = LocalDate.of(year, month, day);

        Person person = new Person(name, gender, birthDate);
        tree.addPerson(person); // Исправлено на вызов addPerson
    }

    private static void findPerson() {
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        Person person = tree.findPersonByName(name); // Исправлено на вызов findPersonByName
        if (person != null) {
            System.out.println("Person found:");
            System.out.println(person);
        } else {
            System.out.println("Person not found.");
        }
    }

    private static void saveTree() {
        System.out.println("Enter file name:");
        String fileName = scanner.nextLine();
        tree.saveToFile(fileName);
        System.out.println("Tree saved to " + fileName);
    }

    private static void loadTree() {
        System.out.println("Enter file name:");
        String fileName = scanner.nextLine();
        tree.loadFromFile(fileName);
        System.out.println("Tree loaded from " + fileName);
    }

    private static void printTree() {
        System.out.println("Current tree contents:");
        System.out.println(tree);
    }
}

