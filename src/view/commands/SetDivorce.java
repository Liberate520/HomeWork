package view.commands;
import view.ConsoleUi;

import java.util.Scanner;

public class SetDivorce extends Command{
    private Scanner scanner;

    public SetDivorce(ConsoleUi consoleUi){
        super("Развод супругов", consoleUi);
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.println("Введите первый ID: ");
        int h = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите второй ID: ");
        int w = Integer.parseInt(scanner.nextLine());
        getConsoleUi().setDivorce(h,w);
    }
}
