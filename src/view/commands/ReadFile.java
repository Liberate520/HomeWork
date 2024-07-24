package view.commands;

import view.ConsoleUI;

public class ReadFile extends Command {
    public ReadFile(ConsoleUI consoleUI) {
        super("Выгрузить существующее дерево", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().read();
    }
}
