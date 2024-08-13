package View.Commands.ForFamilyTree;

import View.Commands.Command;
import View.ConsoleUI;

public class ExitFromFamilyTree extends Command {
    public ExitFromFamilyTree(ConsoleUI consoleUI){
        super("exit", "выход из редактирования семейного древа", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().exitFromFamilyTree();
    }
}
