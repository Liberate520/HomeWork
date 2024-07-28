package view.commands;

import view.ConsoleUI;

public class ReadTree extends Command{

    public ReadTree(ConsoleUI consoleUI) {
        super("Загрузить данные семейного дерева из файла", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().readTree();
    }
}