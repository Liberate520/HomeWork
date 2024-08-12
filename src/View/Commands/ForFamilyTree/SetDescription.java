package View.Commands.ForFamilyTree;

import View.Commands.Command;
import View.ConsoleUI;

public class SetDescription extends Command {
    public SetDescription(ConsoleUI consoleUI){
        super("set description", "Изменить описание", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().setDescription();
    }
}
