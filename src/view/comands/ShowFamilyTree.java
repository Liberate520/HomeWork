package view.comands;

import view.ConsoleUI;

public class ShowFamilyTree extends Command{
    public ShowFamilyTree(ConsoleUI consoleUI) {
        super(consoleUI, "Получить семейное дерево");
    }

    @Override
    public void execute() {
        getConsoleUI().showFamilyTree();
    }
}
