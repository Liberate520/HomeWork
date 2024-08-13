package View.Commands.ForFamilyTree;

import View.Commands.Command;
import View.ConsoleUI;

public class SetGender extends Command {
    public SetGender(ConsoleUI consoleUI){
        super("set gender", "Изменить гендер", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().setGender();
    }
}
