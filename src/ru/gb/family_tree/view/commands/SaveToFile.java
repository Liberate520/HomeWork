package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

import java.io.IOException;

public class SaveToFile extends Command{
    public SaveToFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить в файл";
    }


    public void execute() throws IOException {
        consoleUI.saveToFile();
    }
}
