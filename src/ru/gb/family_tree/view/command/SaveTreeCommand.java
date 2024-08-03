package ru.gb.family_tree.view.command;

import ru.gb.family_tree.view.ConsoleUI;

public class SaveTreeCommand extends Command {
    public SaveTreeCommand(ConsoleUI consoleUI) {
        super("Сохранение семейного древа в файл.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().saveTree();
    }
}
