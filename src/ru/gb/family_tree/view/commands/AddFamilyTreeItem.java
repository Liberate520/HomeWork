package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class AddFamilyTreeItem extends Command {

    public AddFamilyTreeItem(ConsoleUI consoleUI) {
        super("Добавить нового члена семейного древа", consoleUI);        
    }

    @Override
    public void execute() {
        getConsoleUI().addTreeItem();
    }
}
