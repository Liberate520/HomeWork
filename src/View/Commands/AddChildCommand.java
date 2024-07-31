package View.Commands;

import View.ConsoleUI;

public class AddChildCommand extends Command{

    public AddChildCommand(ConsoleUI consoleUI) {
        super("Добавить ребенка", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addChild();
    }
}
