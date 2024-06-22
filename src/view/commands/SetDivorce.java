package view.commands;

import view.ConsoleUI;

public class SetDivorce implements Command {
    private ConsoleUI consoleUI;

    public SetDivorce(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        consoleUI.setDivorce();
    }
}
