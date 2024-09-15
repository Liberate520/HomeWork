package view.commands;
import view.ConsoleUi;

import java.util.Scanner;

public class SetWedding extends Command{
    private Scanner scanner;

    public SetWedding(ConsoleUi consoleUi){
        super("Установить супругов", consoleUi);
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        System.out.println("Введите первый ID: ");
        int h = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите второй ID: ");
        int w = Integer.parseInt(scanner.nextLine());
        getConsoleUi().setWedding(h,w);
    }
}
