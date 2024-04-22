package family_tree.view;

import family_tree.model.person.Gender;
import family_tree.model.person.Human;
import family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {

    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu mainMenu;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void start() {
        hello();
        while (work) {
            int choice = checkUserChoice(getUserChoice());
            if (choice != 0) mainMenu.execute(choice);
            else System.out.println("Try to enter the number of command again please.");
        }
    }

    private String getUserChoice() {
        System.out.println(mainMenu.getMenu());
        String strChoice = scanner.nextLine();
        return strChoice;
    }

    private int checkUserChoice(String userChoice) {
        int choice = 0;
        if (userChoice.matches("\\d")) {
            choice = Integer.parseInt(userChoice);
        } else {
            return choice;
        }
        if ((choice > 0) && (choice <= mainMenu.getNumberOfCommands())) return choice;
        else {
            choice = 0;
        }
        return choice;
    }

    private static void hello() {
        System.out.println("Hello, user!");
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getFamilyTree() {
        presenter.getFamilyTree();
    }

    public void sortByDateOfBirth() {
        presenter.sortByDateOfBirth();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void addNewSubjectToFamilyTree() {
        String name = setNameForNewSubject();
        LocalDate birthDate = setDateOfBirth();
        LocalDate deadDate = setDateOfDead();
        Gender gender = setGender();

        presenter.addSubjectToFamilyTree(name, birthDate, deadDate, gender);
    }

    private Gender setGender() {
        System.out.println("Enter the gender of subject (male or female): ");
        String strGender = scanner.nextLine();
        Gender gender = Gender.Male;
        if (strGender.toLowerCase().contains("fe")) gender = Gender.Female;
        return gender;
    }

    private LocalDate setDateOfDead() {
        System.out.println("Do you know the date of dead of this subject? Enter \"yes\" or \"no\": ");
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Enter the date of dead of subject");
            LocalDate deadDate = setDate();
            return deadDate;
        } else {
            return null;
        }
    }

    private LocalDate setDateOfBirth() {
        System.out.println("Enter the date of birth of subject");
        LocalDate birthDate = setDate();
        return birthDate;
    }

    private LocalDate setDate() {
        System.out.print("year -> ");
        int year = Integer.parseInt(scanner.nextLine());// Method for searching the correctness of the entered data
        System.out.print("month -> ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.print("day -> ");
        int day = Integer.parseInt(scanner.nextLine());
        return LocalDate.of(year, month, day);
    }

    private String setNameForNewSubject() {
        System.out.println("Enter the name of subject: ");
        String name = scanner.nextLine();
        return name;
    }

    public void finish() {
        System.out.println("Good luck!");
        scanner.close();
        work = false;
    }

    @Override
    public void getAnswer(String text) {
        System.out.print(text);
    }

    public void writeTreeAsByteCode() {
        presenter.writeTreeAsByteCode();
    }

    public void readTreeFromByteCodeFile() {
        presenter.readTreeFromByteCodeFile();
    }

}
