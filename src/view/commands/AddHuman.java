package view.commands;

import view.ConsoleUI;

public class AddHuman extends Command{
    private String description;
    private ConsoleUI consoleUI;

    public AddHuman(ConsoleUI consoleUI) {
        super("Добавить человека", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addHuman();
    }
}
