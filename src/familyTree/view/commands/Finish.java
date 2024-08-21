package familyTree.view.commands;

import familyTree.view.ConsoleUI;

public class Finish extends Command{
    private String description;
    private ConsoleUI consoleUI;

    public Finish(ConsoleUI consoleUI) {
        super("Закрыть программу", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().finish();
    }
}