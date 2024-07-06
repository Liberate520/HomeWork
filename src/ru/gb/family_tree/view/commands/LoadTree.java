package ru.gb.family_tree.view.commands;

import java.io.FileNotFoundException;
import java.io.IOException;

import ru.gb.family_tree.view.ConsoleUI;

public class LoadTree extends Command{

    public LoadTree(ConsoleUI consoleUI) {
        super("Загрузить семейное древо из файла", consoleUI);
    }

    @Override
    public void execute() throws FileNotFoundException, ClassNotFoundException, IOException {
        getConsoleUI().loadTree();
    }

}
