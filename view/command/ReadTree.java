package view.command;

import view.ConsoleUI;

public class ReadTree extends Command {
    public ReadTree(ConsoleUI consoleUI) {
        super("Загрузить древо.", consoleUI);
    }

    @Override
    public void execute() {
        super.getConsoleUI().readTree();
    }
}
