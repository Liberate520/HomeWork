package view.commands;

import model.human.Human;
import view.ConsoleUi;

import java.util.Scanner;

public class FindHuman  extends Command{
    private Scanner scanner;

    public FindHuman(ConsoleUi consoleUi) {
        super("Выбрать человека по ID", consoleUi);
        scanner = new Scanner(System.in);
    }



    @Override
    public Human execute() {
        System.out.println("Введите ID человека: ");
        String idString = scanner.nextLine();
        int id = Integer.parseInt(idString);
        return getConsoleUi().findHuman(id);
    }
}
