package ru.gb.family_tree.view.commands;

import java.io.FileNotFoundException;
import java.io.IOException;

import ru.gb.family_tree.view.ConsoleUI;

public class AddRelative extends Command {

    public AddRelative(ConsoleUI consoleUI) {
        super("Создать родственную связь", consoleUI);        
    }

    @Override
    public void execute() throws FileNotFoundException, ClassNotFoundException, IOException {
        getConsoleUI().addRelative();
    }
}
