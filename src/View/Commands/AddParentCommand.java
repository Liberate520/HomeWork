package View.Commands;

import View.ConsoleUI;

import java.io.IOException;

public class AddParentCommand extends Command{

    public AddParentCommand(ConsoleUI consoleUI) {
        super("Добавить родителя", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addParent();
    }
}
