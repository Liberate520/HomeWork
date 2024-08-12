package View.Commands.ForFamilyTree;

import View.Commands.Command;
import View.ConsoleUI;

public class PrintEntity extends Command{
    public PrintEntity(ConsoleUI consoleUI){
        super("print", "Вывод существа по его ID", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().printEntity();
    }
}
