package view.commands;

import view.ConsoleUI;

public class AddPlace extends Command {

    public AddPlace(ConsoleUI consoleUI) {
        super("Добавить место", consoleUI);
    }

    public void execute() {
        getConsoleUI().addPlace();
    }
}
