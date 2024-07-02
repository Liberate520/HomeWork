package view.command;

import view.ConsoleUI;

public class SetParents extends Command {

    public SetParents(ConsoleUI consoleUI) {
        super("Добавить родителей", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().setParents();
    }
}
