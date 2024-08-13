package View.Commands.ForFamilyTree;

import View.Commands.Command;
import View.ConsoleUI;

public class SetDateOfDeath extends Command {
    public SetDateOfDeath(ConsoleUI consoleUI){
        super("set date of death", "Изменить дату смерти", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().setDataOfDeath();
    }
}
