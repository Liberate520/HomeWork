package view.commands;

import view.ConsoleUi;

import java.util.Scanner;

public class LoadTree extends Command{
    private Scanner scanner;

    public LoadTree(ConsoleUi consoleUi) {
        super("Загрузить дерево из файла", consoleUi);
        scanner = new Scanner(System.in);
    }



    @Override
    public void execute() {
        getConsoleUi().loadTree();

    }
}
