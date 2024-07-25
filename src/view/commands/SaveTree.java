package view.commands;

import view.ConsoleUI;

public class SaveTree extends Commands {

    public SaveTree(ConsoleUI consoleUI) {
        super("Сохранить созданное семейное древо.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().saveTree();
    }
}
