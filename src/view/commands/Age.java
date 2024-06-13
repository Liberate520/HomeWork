package view.commands;

import view.ConsoleUI;

public class Age extends Command {

    public Age(ConsoleUI consoleUI) {
        super("Показать возраст", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getAge();
    }
}
