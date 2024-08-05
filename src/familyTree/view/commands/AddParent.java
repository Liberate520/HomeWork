package familyTree.view.commands;

import familyTree.view.ConsoleUI;

public class AddParent extends Command{
    private String description;
    private ConsoleUI consoleUI;

    public AddParent(ConsoleUI consoleUI) {
        super("Добавить человеку родителя", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addParent();
    }
}