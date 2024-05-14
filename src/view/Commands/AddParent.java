package view.Commands;

import view.ConsoleUI;

public class AddParent extends Command {
    public AddParent(ConsoleUI consoleUI) {
        super("Добавить родителя", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addParent();
    }
}