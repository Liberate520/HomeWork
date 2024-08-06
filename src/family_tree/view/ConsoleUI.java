package family_tree.view;

import family_tree.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View {
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private Menu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new Menu();
    }

    @Override
    public void printAnswer(String text) {
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

    private void execute() {
        try {
            int choice = Integer.parseInt(scanner.nextLine());
            menu.performAction(choice, presenter);
        } catch (NumberFormatException e) {
            inputError();
        }
    }

    public void printMenu() {
        menu.displayMenu();
    }

    private void hello() {
        System.out.println("Hello!");
    }

    private void inputError() {
        System.out.println(INPUT_ERROR);
    }


}
