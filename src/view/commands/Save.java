package view.commands;

import view.ConsoleUI;

public class Save extends Command{

    public Save(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить.";
    }

    @Override
    public void execute() {
        consoleUI.save();
    }
}
