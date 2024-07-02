package view.command;

import view.ConsoleUI;

public class Save extends Command {

    public Save(ConsoleUI consoleUI) {
        super("Сохранить семейное дерево", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().savingTree();
    }
}
