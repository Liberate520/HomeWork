package view.Commands;

import view.ConsoleUI;

public class LoadFamilyTree extends Command {
    public LoadFamilyTree(ConsoleUI consoleUI){
        super("Загрузить семейное древо", consoleUI);
    }
    @Override
    public void execute() {
        getConsoleUI().loadFamilyTree();
    }
}
