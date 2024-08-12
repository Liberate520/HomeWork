package View.Commands.ForFamilyTree;

import View.Commands.Command;
import View.ConsoleUI;

public class SetName extends Command{
    public SetName(ConsoleUI consoleUI){
        super("set", "Изменение имени существа", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().setEntityName();
    }
}
