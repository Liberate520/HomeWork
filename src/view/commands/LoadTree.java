package view.commands;

import view.ConsoleUI;

public class LoadTree extends Commands {

    public LoadTree(ConsoleUI consoleUI) {
        super("Загрузить ранее созданное семейное древо", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().loadTree();
    }
}
