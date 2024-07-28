package view.commands.set;

import view.ConsoleUI;
import view.commands.Command;

public class SetDateOfDeath extends Command {
    public SetDateOfDeath(ConsoleUI consoleUI) {
        super("Указать дату смерти человека", consoleUI);
    }

    @Override
    public void execute(){
        getConsoleUI().setDateOfDeath();
    }
}