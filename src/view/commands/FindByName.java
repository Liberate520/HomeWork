package view.commands;

import view.ConsoleUI;

public class FindByName extends Command{

    public FindByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Найти человека по имени.";
    }

    @Override
    public void execute() {
        consoleUI.findByName();
    }
}
