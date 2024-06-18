package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

import java.io.IOException;

public class LoadFile extends Command{
    public LoadFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить файл";
    }


    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.loadFile();
    }
}
