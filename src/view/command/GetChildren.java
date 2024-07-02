package view.command;

import view.ConsoleUI;

public class GetChildren extends Command {

    public GetChildren(ConsoleUI consoleUI) {
        super("Показать детей", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getChildren();
    }
}
