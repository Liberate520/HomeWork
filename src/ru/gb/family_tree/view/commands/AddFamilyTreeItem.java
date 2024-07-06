package ru.gb.family_tree.view.commands;

import java.io.FileNotFoundException;
import java.io.IOException;

import ru.gb.family_tree.view.ConsoleUI;

public class AddFamilyTreeItem extends Command {

    public AddFamilyTreeItem(ConsoleUI consoleUI) {
        super("Добавить нового члена семейного древа", consoleUI);        
    }

    @Override
    public void execute() throws FileNotFoundException, ClassNotFoundException, IOException {
        getConsoleUI().addTreeItem();
    }
}
