package familyTree.view.commands;

import familyTree.view.ConsoleUI;

public class AddChild extends Command{
    private String description;
    private ConsoleUI consoleUI;

    public AddChild(ConsoleUI consoleUI) {
        super("Добавить человеку сына/дочь", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addChild();
    }
}