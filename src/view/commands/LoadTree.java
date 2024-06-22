package view.commands;

import view.ConsoleUI;

public class LoadTree implements Command {
    private ConsoleUI consoleUI;

    public LoadTree(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        consoleUI.loadTree();
    }
}
