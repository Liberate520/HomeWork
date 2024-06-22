package view.commands;

import view.ConsoleUI;

public class AddMember implements Command {
    private ConsoleUI consoleUI;

    public AddMember(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        consoleUI.addMember();
    }
}
