package View.Commands.ForFamilyTree;

import View.Commands.Command;
import View.ConsoleUI;

public class PrintDescription extends Command {
    public PrintDescription(ConsoleUI consoleUI){
        super("print description", "Вывести описание древа", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().printDescription();
    }
}
