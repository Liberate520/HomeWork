package view.commands;

import view.ConsoleUI;

public class SetDeathDate extends Command{

    public SetDeathDate(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Установить дату смерти.";
    }

    @Override
    public void execute() {
        consoleUI.setDeathDate();
    }
}
