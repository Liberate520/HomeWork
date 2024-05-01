package view;

import model.familyTree.FamilyTree;
import model.human.Human;
import presenter.Presenter;
import view.util.ConsoleColors;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {

    private static final String INPUT_ERROR = ConsoleColors.RED_BOLD + "Wrong Number!" + ConsoleColors.RESET;
    private Presenter presenter;
    private Scanner scanner;
    private Menu menu;
    private boolean work;

    public ConsoleUI(FamilyTree<Human> familyTree) {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this, familyTree);
        work = true;
        menu = new Menu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        hello();
        while (work) {
            printMenu();
            execute();
        }
    }

    public void finish() {
        System.out.println(ConsoleColors.GREEN_BOLD + "Good Luck!" + ConsoleColors.RESET);
        work = false;
    }

    public void sortByDayOfBirth() {
        presenter.sortByDayOfBirth();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void loadTree () {
        presenter.loadTree();
    }

    public void getHumanList() {
        presenter.getHumanList();
    }

    public void addHuman() {
        System.out.println("name:");
        String name = scanner.nextLine();
        System.out.println("second name:");
        String secondName = scanner.nextLine();
        System.out.println("gender (male / female):");
        String gender = scanner.nextLine();
        System.out.println("Year of Birth:");
        String year = scanner.nextLine();
        System.out.println("Month of Birth:");
        String month = scanner.nextLine();
        System.out.println("Day of Birth:");
        String day = scanner.nextLine();
        //сделать проверку ввода возраста
        presenter.addHuman(name, secondName, gender, LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day)).toString());
    }

    private void hello() {
        System.out.println(ConsoleColors.GREEN_BOLD + "Hello! Let's start..." + ConsoleColors.RESET);
    }

    private void execute() {
        String line = scanner.nextLine();
        if (checkTextForInt(line)) {
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)) {
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text) {
        if (text.matches("[0-9]+")) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand) {
        if (numCommand <= menu.getSize()) {
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    private void inputError() {
        System.out.println(INPUT_ERROR);
    }
}
