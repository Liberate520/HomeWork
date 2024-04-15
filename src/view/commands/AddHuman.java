package view.commands;

import view.ConsoleUI;

public class AddHuman extends Command {
    public AddHuman(ConsoleUI consoleUI) {
        super("Добавить человека в семейное древо", consoleUI);
    }

    public void execute() {
        getConsoleUI().addHuman();
    }
}