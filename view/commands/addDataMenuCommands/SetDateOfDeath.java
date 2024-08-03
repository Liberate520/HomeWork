package view.commands.addDataMenuCommands;

import view.ConsoleUI;
import view.commands.Command;

public class SetDateOfDeath extends Command {
    public SetDateOfDeath(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить дату смерти";
    }

    @Override
    public void execute() {
        consoleUI.setDateOfDeath();
    }
}