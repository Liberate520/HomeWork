package familyTree.view.commands;

import familyTree.view.ConsoleUI;

public class GetFamilyTree extends Command{
    private String description;
    private ConsoleUI consoleUI;

    public GetFamilyTree(ConsoleUI consoleUI) {
        super("Показать семейное древо", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getFamilyTree();
    }
}