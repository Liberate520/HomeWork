package view.Commands;

import view.ConsoleUI;

public class SaveFamilyTree extends Command {
    public SaveFamilyTree(ConsoleUI consoleUI){
        super("Сохранить семейное древо", consoleUI);
    }
    @Override
    public void execute() {
        getConsoleUI().saveFamilyTree();
    }
}