package View.Commands.ForFamilyTree;

import View.Commands.Command;
import View.ConsoleUI;

public class SetFileName extends Command {
    public SetFileName(ConsoleUI consoleUI){
        super("set file name", "Изменить имя файла", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().setFileName();
    }
}
