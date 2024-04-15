package view.commands;

import view.ConsoleUI;

public class AddDeathDate extends Command {
    public AddDeathDate(ConsoleUI consoleUI) {
        super("Добавить дату смерти", consoleUI);
    }

    public void execute() {
        getConsoleUI().addDeathDate();
    }
}