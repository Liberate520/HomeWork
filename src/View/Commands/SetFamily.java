package View.Commands;

import View.ConsoleUI;

public class SetFamily extends Command {
    public SetFamily(ConsoleUI consoleUI) {
        super("Добавить родителя", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().SetFamily();
    }
}
