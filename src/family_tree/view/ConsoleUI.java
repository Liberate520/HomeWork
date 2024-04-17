package family_tree.view;

import family_tree.model.person.Gender;
import family_tree.model.person.Human;
import family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {

    private Scanner scanner;
    private Presenter presenter;
    boolean work;
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
            if(choice != 0) mainMenu.execute(choice);
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
        if (userChoice.matches("\\d+")) {
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
        System.out.println("Enter the type of subject (human or another(not yet developed): ");
        String type = scanner.nextLine();
        if (type.equalsIgnoreCase("human")) {
            Class clazz = Human.class;
        }
        Class clazz = Human.class; // temporary solution
        System.out.println("Enter the name of subject: ");
        String name = scanner.nextLine();

        System.out.println("Enter the date of birth of subject");
        System.out.print("year of birth -> ");
        int year = Integer.parseInt(scanner.nextLine());// Method for searching the correctness of the entered data
        System.out.print("month of birth -> ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.print("day of birth -> ");
        int day = Integer.parseInt(scanner.nextLine());

        System.out.println("Do you know the date of dead of this subject? Enter \"yes\" or \"no\": ");
        LocalDate deadDate = null;
        if (scanner.nextLine().equalsIgnoreCase("yes")) {
            System.out.println("Enter the date of dead of subject");
            System.out.print("year of dead -> ");
            int deadYear = Integer.parseInt(scanner.nextLine());// Method for searching the correctness of the entered data
            System.out.print("month of dead -> ");
            int deadMonth = Integer.parseInt(scanner.nextLine());
            System.out.print("day of dead -> ");
            int deadDay = Integer.parseInt(scanner.nextLine());
            deadDate = LocalDate.of(deadYear, deadMonth, deadDay);
        }

        System.out.println("Enter the gender of subject (male or female): ");
        String strGender = scanner.nextLine();
        Gender gender = Gender.Male;
        if (strGender.toLowerCase().contains("fe")) gender = Gender.Female;

        presenter.addSubjectToFamilyTree(name, LocalDate.of(year, month, day), deadDate != null ? deadDate : null, gender, clazz);
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
}
