package view.comands;

import view.ConsoleUI;

public class ReadFamilyTree extends Command{
    public ReadFamilyTree(ConsoleUI consoleUI) {
        super(consoleUI, "Загрузить семейное деревво");
    }

    @Override
    public void execute() {
        getConsoleUI().ReadFamilyTree();
    }
}
