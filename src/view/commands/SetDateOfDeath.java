package view.commands;

import view.ConsoleUI;

public class SetDateOfDeath extends Command{
    public SetDateOfDeath(ConsoleUI consoleUI) {
        super("Добавить дату смерти", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().setDateOfDeath();
    }
}
