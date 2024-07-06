package ru.gb.family_tree.view.commands;

import java.io.FileNotFoundException;
import java.io.IOException;

import ru.gb.family_tree.view.ConsoleUI;

public class SaveTree extends Command{
    
    public SaveTree (ConsoleUI consoleUI) {
        super("Сохранить семейное древо в файл", consoleUI);
    }

    @Override
    public void execute() throws FileNotFoundException, IOException {
        getConsoleUI().saveTree();
    }
}
