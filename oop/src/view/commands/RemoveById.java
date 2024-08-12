package view.commands;

import view.ConsoleUI;

public class RemoveById extends Command {

    public RemoveById(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Удалить по ID";
    }

    public void execute() {
        consoleUI.removeById();
    }
}

