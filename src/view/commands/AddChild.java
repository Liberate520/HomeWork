package view.commands;

import view.ConsoleUI;

public class AddChild extends Command {
    public AddChild(ConsoleUI consoleUI) {
        super("Добавить связь Родитель <-> Ребенок", consoleUI);
    }

    public void execute() {
        getConsoleUI().addChild();
    }
}