package View.Commands.ForFamilyTree;

import View.Commands.Command;
import View.ConsoleUI;

public class PrintFamilyTree extends Command{
    public PrintFamilyTree(ConsoleUI consoleUI){
        super("print tree", "Вывод всех существ в семейном древе", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().printFamilyTree();
    }
}
