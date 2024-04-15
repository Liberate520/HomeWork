package view.commands;

import view.ConsoleUI;

public class GetTreeInfo extends Command {
    public GetTreeInfo(ConsoleUI consoleUI) {
        super("Показать семейное древо", consoleUI);
    }

    public void execute() {
        getConsoleUI().getTreeInfo();
    }
}