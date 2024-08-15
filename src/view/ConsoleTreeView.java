package view;

import presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleTreeView implements TreeView {
    private Presenter presenter;

    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter command (add, find, display, sortName, sortBirth, save, load, exit): ");
            String command = scanner.nextLine();
            if (command.equalsIgnoreCase("exit")) {
                break;
            }
            handleCommand(command, scanner);
        }
    }

    private void handleCommand(String command, Scanner scanner) {
        switch (command.toLowerCase()) {
            case "add":
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter birth date (YYYY-MM-DD): ");
                LocalDate birthDate = LocalDate.parse(scanner.nextLine());
                System.out.print("Enter death date (YYYY-MM-DD): ");
                LocalDate deathDate = LocalDate.parse(scanner.nextLine());
                System.out.print("Enter gender (MALE/FEMALE): ");
                String gender = scanner.nextLine();
                presenter.addPerson(name, birthDate, deathDate, gender);
                break;
            case "find":
                System.out.print("Enter name to find: ");
                String findName = scanner.nextLine();
                presenter.findPerson(findName);
                break;
            case "display":
                presenter.displayAllPersons();
                break;
            case "sortname":
                presenter.sortByName();
                presenter.displayAllPersons();
                break;
            case "sortbirth":
                presenter.sortByBirthDate();
                presenter.displayAllPersons();
                break;
            case "save":
                System.out.print("Enter file name to save: ");
                String saveFileName = scanner.nextLine();
                presenter.saveTree(saveFileName);
                break;
            case "load":
                System.out.print("Enter file name to load: ");
                String loadFileName = scanner.nextLine();
                presenter.loadTree(loadFileName);
                break;
            default:
                System.out.println("Unknown command.");
        }
    }

    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    @Override
    public void displayPerson(String personInfo) {
        System.out.println(personInfo);
    }

    @Override
    public void displayAllPersons(String personsInfo) {

        System.out.println(personsInfo);
    }


}
