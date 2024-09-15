package view.commands;

import view.ConsoleUi;

import java.util.Scanner;

public class SaveTree extends Command{
    private Scanner scanner;

    public SaveTree(ConsoleUi consoleUi) {
        super("Сохранить дерево в файл", consoleUi);
        scanner = new Scanner(System.in);
    }

    @Override
    public void execute() {
        getConsoleUi().saveTree();

    }
}
