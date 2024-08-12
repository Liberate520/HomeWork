package View.Commands.ForFamilyTree;

import View.Commands.Command;
import View.ConsoleUI;

public class SaveTree extends Command {
    public SaveTree(ConsoleUI consoleUI){
        super("save", "Сохранить семейное дерево", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().saveTree();
    }
}
