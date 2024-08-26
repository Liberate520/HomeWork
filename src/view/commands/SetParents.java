package view.commands;

import view.ConsoleUI;

public class SetParents extends Command{

    public SetParents(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Установить родителей.";
    }

    @Override
    public void execute() {
        consoleUI.setParents();
    }
}
