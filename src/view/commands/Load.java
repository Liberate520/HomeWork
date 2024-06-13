package view.commands;

import view.ConsoleUI;

public class Load extends Command {

    public Load(ConsoleUI consoleUI) {
        super("Загрузить семейное дерево", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().loadingTree();
    }
}
