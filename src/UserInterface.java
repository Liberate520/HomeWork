import familytree.FamilyTree;
import person.Gender;
import person.Person;
import writer.FileHandler;
import writer.Writer;

import java.time.LocalDate;
import java.util.Scanner;

public class UserInterface {
    private FamilyTree<Person> tree;
    private Scanner scanner;
    private Writer fileHandler;

    public UserInterface() {
        this.tree = new FamilyTree<>();
        this.scanner = new Scanner(System.in);
        this.fileHandler = new FileHandler();
    }

    public void start() {
        while (true) {
            System.out.println("\n1. Add Person");
            System.out.println("2. Find Person");
            System.out.println("3. List all members");
            System.out.println("4. Sort by Name");
            System.out.println("5. Sort by Birth Date");
            System.out.println("6. Save to File");
            System.out.println("7. Load from File");
            System.out.println("8. Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addPerson();
                    break;
                case "2":
                    findPerson();
                    break;
                case "3":
                    listMembers();
                    break;
                case "4":
                    sortByName();
                    break;
                case "5":
                    sortByBirthDate();
                    break;
                case "6":
                    saveToFile();
                    break;
                case "7":
                    loadFromFile();
                    break;
                case "8":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addPerson() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter birth date (YYYY-MM-DD): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter death date (YYYY-MM-DD) or leave blank if alive: ");
        String deathDateInput = scanner.nextLine();
        LocalDate deathDate = deathDateInput.isEmpty() ? null : LocalDate.parse(deathDateInput);

        System.out.print("Enter gender (MALE/FEMALE): ");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());

        Person person = new Person(name, birthDate, deathDate, gender);
        tree.addPerson(person);

        System.out.println("Person added: " + person);
    }

    private void findPerson() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        Person person = tree.findPersonByName(name);
        if (person != null) {
            System.out.println("Person found: " + person);
        } else {
            System.out.println("Person not found.");
        }
    }

    private void listMembers() {
        System.out.println(tree);
    }

    private void sortByName() {
        tree.sortByName();
        System.out.println("Tree sorted by name.");
    }

    private void sortByBirthDate() {
        tree.sortByBirthDate();
        System.out.println("Tree sorted by birth date.");
    }

    private void saveToFile() {
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();
        fileHandler.writeToFile(tree, fileName);
        System.out.println("Tree saved to file: " + fileName);
    }

    private void loadFromFile() {
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();
        FamilyTree<Person> loadedTree = fileHandler.readFromFile(fileName);
        if (loadedTree != null) {
            tree = loadedTree;
            System.out.println("Tree loaded from file: " + fileName);
        } else {
            System.out.println("Failed to load tree from file.");
        }
    }
}
