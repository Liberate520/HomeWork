package view.allcommands;

import view.ConsoleUI;

public class ShowTree extends Command{
    public ShowTree(ConsoleUI consoleUI) {
        super(consoleUI);
        description="Показать семейное древо";
    }
    @Override
    public void execute() {
        consoleUI.showTree();
    }
}
