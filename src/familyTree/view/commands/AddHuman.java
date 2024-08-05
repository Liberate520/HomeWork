package familyTree.view.commands;

import familyTree.view.ConsoleUI;

public class AddHuman extends Command{
    private String description;
    private ConsoleUI consoleUI;

    public AddHuman(ConsoleUI consoleUI) {
        super("Добавить человека", consoleUI);
    }

    @Override
    public void execute() {
    getConsoleUI().addHuman();
    }
}
