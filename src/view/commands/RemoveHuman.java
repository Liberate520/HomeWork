package view.commands;

import view.ConsoleUi;

import java.util.Scanner;

public class RemoveHuman extends Command{
    private Scanner scanner;

    public RemoveHuman(ConsoleUi consoleUi) {
        super("Удалить человека по ID", consoleUi);
        scanner = new Scanner(System.in);
    }



    @Override
    public void execute() {
        System.out.println("Введите ID человека: ");
        String idString = scanner.nextLine();
        int id = Integer.parseInt(idString);
        getConsoleUi().removeHuman(id);
    }
}