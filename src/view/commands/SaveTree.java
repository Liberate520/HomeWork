package view.commands;

import view.ConsoleUI;

public class SaveTree implements Command {
    private ConsoleUI consoleUI;

    public SaveTree(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        consoleUI.saveTree();
    }
}
