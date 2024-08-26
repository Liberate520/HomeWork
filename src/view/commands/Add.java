package view.commands;

import view.ConsoleUI;

public class Add extends Command{

    public Add(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить человека.";
    }

    @Override
    public void execute() {
        consoleUI.add();
    }
}
