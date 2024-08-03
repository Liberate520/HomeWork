package ru.gb.family_tree.view.command;

import ru.gb.family_tree.view.ConsoleUI;

public class CreateFamilyTreeCommand extends Command {
    public CreateFamilyTreeCommand(ConsoleUI consoleUI) {
        super("Заполнить семейное древо.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().createFamilyTree();
    }
}
