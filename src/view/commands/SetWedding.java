package view.commands;

import view.ConsoleUI;

public class SetWedding implements Command {
    private ConsoleUI consoleUI;

    public SetWedding(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        consoleUI.setWedding();
    }
}
