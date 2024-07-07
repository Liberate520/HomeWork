package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

import java.io.IOException;

public class ReadFile extends Commands{
    public ReadFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить данные из файла";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.readData();
    }
}
