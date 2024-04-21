package familytree.view.commands;

import familytree.view.ConsoleUI;

public class ShowFamilyTree extends Command {

    public ShowFamilyTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать семейное древо";
    }

    public void execute() {
        consoleUI.showFamilyTree();
    }
}
