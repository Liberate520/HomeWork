package view.commands;

import view.ConsoleUi;

import java.util.Scanner;

public class SetParent  extends Command{
    private Scanner scanner;

    public SetParent(ConsoleUi consoleUi) {
        super("Добавить родителя по Id", consoleUi);
        scanner = new Scanner(System.in);
    }



    @Override
    public void execute() {
        System.out.println("Введите ID человека: ");
        int idHuman = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите ID родителя: ");
        int idParent = Integer.parseInt(scanner.nextLine());
        getConsoleUi().setParent(idParent, idHuman);
    }
}