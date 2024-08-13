package View.Commands.ForDatabase;

import View.Commands.Command;
import View.ConsoleUI;

public class CreateFamilyTree extends Command {

    public CreateFamilyTree(ConsoleUI consoleUI){
        super("new", "Создание нового дерева", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().createFamilyTree();
    }
}
