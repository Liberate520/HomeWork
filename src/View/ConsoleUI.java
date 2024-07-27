package View;

import Presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleUI implements View {
    Scanner scanner;
    Presenter presenter;
    MainMenu mainMenu;
    boolean work;
    private static ConsoleUI instance;

    private ConsoleUI() {
        System.out.println("ConsoleUI constructor called");
        scanner = new Scanner((System.in));
        presenter = Presenter.getInstance();
        work = true;
        this.mainMenu = new MainMenu();
    }

    public static ConsoleUI getInstance() {
        if (instance == null) {
            System.out.println("Creating new instance of ConsoleUI");
            instance = new ConsoleUI();
        }
        return instance;
    }
    @Override
    public void startMenu() throws IOException, ClassNotFoundException {
        while (work) {
            System.out.println("Выберите пункт меню:");
            System.out.println(mainMenu.toString());
            int choice = scanner.nextInt();
            scanner.nextLine();
            mainMenu.chooseCommand(choice).execute();
        }
    }
    public void stopMenu(){
        this.work = false;
    }
}

