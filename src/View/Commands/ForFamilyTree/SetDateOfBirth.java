package View.Commands.ForFamilyTree;

import View.Commands.Command;
import View.ConsoleUI;

public class SetDateOfBirth extends Command {
    public SetDateOfBirth(ConsoleUI consoleUI){
        super("set date of birth", "Изменить дату рождения существа", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().setDateOfBirth();
    }
}
