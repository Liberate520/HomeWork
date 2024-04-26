package view.commands;

import view.ConsoleUI;

public class AddFirst extends Command {
    public AddFirst(ConsoleUI consoleUI) {
        super("Добавление \"прородителей\" в семейное древо", consoleUI);
    }

    public void execute() {
        getConsoleUI().addFirst();
    }
}