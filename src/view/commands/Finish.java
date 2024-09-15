package view.commands;

import view.ConsoleUi;

import java.util.Scanner;

public class Finish extends Command{
    private Scanner scanner;

    public Finish(ConsoleUi consoleUi) {
        super("Завершить работу", consoleUi);
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        getConsoleUi().finish();
    }
}
