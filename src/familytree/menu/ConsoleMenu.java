package familytree.menu;

import familytree.presenter.IFamilyTreePresenter;

import familytree.presenter.FamilyTreePresenter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleMenu {
    private Map<Integer, Command> commandMap;
    private Scanner scanner;
    private FamilyTreePresenter presenter;
    private boolean work;

    public ConsoleMenu(IFamilyTreePresenter presenter) {
        this.presenter = (FamilyTreePresenter) presenter;
        work = true;
        this.scanner = new Scanner(System.in);
        this.commandMap = new HashMap<>();
        initializeCommands();
    }

    private void initializeCommands() {
        commandMap.put(1, new PrintTreeCommand(presenter));
        commandMap.put(2, new SaveTreeCommand(presenter));
        commandMap.put(3, new LoadTreeCommand(presenter));
        commandMap.put(4, new SortByAgeCommand(presenter));
        commandMap.put(5, new SortByNameCommand(presenter));
        commandMap.put(6, new AddHumanCommand(presenter, "", "", "", "")); 
        commandMap.put(7, new AddParentToChildCommand(presenter, "", "")); 
        commandMap.put(8, new AddChildToParentCommand(presenter, "", "")); 
    }

    public void displayMenu() {
        while (work) {
            System.out.println("Select action:");
            System.out.println("1. Print a tree");
            System.out.println("2. Save the tree to a file");
            System.out.println("3. Load a tree from a file");
            System.out.println("4. Sort by age");
            System.out.println("5. Sort by name");
            System.out.println("6. Add human");
            System.out.println("7. Add parent to child");
            System.out.println("8. Add child to parent");
            System.out.println("9. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            if (choice == 9) {
                finish();
                break;
            }

            Command command = commandMap.get(choice);
            if (command != null) {
                if (choice == 6) {
                    addHumanCommand();
                } else if (choice == 7) {
                    addParentToChildCommand();
                } else if (choice == 8) {
                    addChildToParentCommand();
                } else {
                    command.execute();
                }
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void finish() {
        work = false;
        scanner.close();
        System.out.println("Exit");
    }

    private void addHumanCommand() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter gender (Male/Female): ");
        String gender = scanner.nextLine();

        System.out.print("Enter birthdate (YYYY-MM-DD): ");
        String birthDate = scanner.nextLine();

        System.out.print("Enter deathdate (YYYY-MM-DD) or leave blank: ");
        String deathDate = scanner.nextLine();

        Command command = new AddHumanCommand(presenter, name, gender, birthDate, deathDate);
        command.execute();
    }

    private void addParentToChildCommand() {
        System.out.print("Enter child's name: ");
        String childName = scanner.nextLine();

        System.out.print("Enter parent's name: ");
        String parentName = scanner.nextLine();

        Command command = new AddParentToChildCommand(presenter, childName, parentName);
        command.execute();
    }

    private void addChildToParentCommand() {
        System.out.print("Enter parent's name: ");
        String parentName = scanner.nextLine();

        System.out.print("Enter child's name: ");
        String childName = scanner.nextLine();

        Command command = new AddChildToParentCommand(presenter, parentName, childName);
        command.execute();
    }
}