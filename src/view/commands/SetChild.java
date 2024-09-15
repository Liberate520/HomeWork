package view.commands;

import view.ConsoleUi;

import java.util.Scanner;

public class SetChild extends Command{
    private Scanner scanner;

    public SetChild(ConsoleUi consoleUi) {
        super("Добавить ребенка по Id", consoleUi);
        scanner = new Scanner(System.in);
    }



    @Override
    public void execute() {
        System.out.println("Введите ID человека: ");
        int idHuman = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите ID ребенка: ");
        int idChild = Integer.parseInt(scanner.nextLine());
        getConsoleUi().setChild(idChild, idHuman);
    }
}