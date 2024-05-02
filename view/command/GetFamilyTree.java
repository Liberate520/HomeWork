package view.command;

import view.ConsoleUI;

public class GetFamilyTree extends Command {
    public GetFamilyTree(ConsoleUI consoleUI) {
        super("Показать семейное древо.", consoleUI);
    }


    @Override
    public void execute() {
        super.getConsoleUI().getTree();
    }
}
