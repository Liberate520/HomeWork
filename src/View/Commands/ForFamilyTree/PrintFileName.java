package View.Commands.ForFamilyTree;

import View.Commands.Command;
import View.ConsoleUI;

public class PrintFileName extends Command {
    public PrintFileName(ConsoleUI consoleUI){
        super("print file name", "Вывести имя файла", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().printFilename();
    }
}
