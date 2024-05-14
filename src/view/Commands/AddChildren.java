package view.Commands;

import view.ConsoleUI;

public class AddChildren extends Command {
    public AddChildren(ConsoleUI consoleUI) {
        super("Добавить ребенка", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addChildren();
    }
}