package View.Commands.ForFamilyTree;

import View.Commands.Command;
import View.ConsoleUI;

public class SetMather extends Command{
    public SetMather(ConsoleUI consoleUI){
        super("set mather", "Изменить мать у существа", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().setEntityMather();
    }
}
