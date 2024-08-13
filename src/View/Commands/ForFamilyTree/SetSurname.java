package View.Commands.ForFamilyTree;

import View.Commands.Command;
import View.ConsoleUI;

public class SetSurname extends Command{
    public SetSurname(ConsoleUI consoleUI){
        super("set surname", "Изменить фамилию", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().setEntitySurname();
    }
}
