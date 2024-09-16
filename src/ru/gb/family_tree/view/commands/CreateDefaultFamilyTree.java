package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class CreateDefaultFamilyTree extends Command {
    private String description;
    private ConsoleUI consoleUI;

    public CreateDefaultFamilyTree(ConsoleUI consoleUI) {
        super("Create default family tree", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().createDefaultFamilyTree();
    }
}