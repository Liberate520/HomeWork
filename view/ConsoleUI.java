package view;

import java.util.Scanner;

import presenter.Presenter;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;

    public ConsoleUI(Presenter presenter) {
        this.scanner = new Scanner(System.in);
        this.presenter = presenter;
        this.work = true;
    }

    @Override
    public void start() {
        System.out.println("Добро пожаловать в наше семейное дерево!");
        while (work) {
            System.out.println(presenter.getMenu());
            int choice = Integer.parseInt(scanner.nextLine());
            presenter.executeCommand(choice);
        }
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    public void finish() {
        System.out.println("Всего доброго!");
        work = false;
    }
}