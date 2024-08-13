package View.Commands.ForFamilyTree;

import View.Commands.Command;
import View.ConsoleUI;

public class SetFather extends Command {
    public SetFather(ConsoleUI consoleUI){
        super("set father", "Изменить отца у существа", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().setEntityFather();
    }
}
