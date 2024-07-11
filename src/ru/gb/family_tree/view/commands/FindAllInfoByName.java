package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

import java.io.IOException;

public class FindAllInfoByName extends Commands{

    public FindAllInfoByName(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Полный поиск по имени.";
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.findAllInfoByName();
    }
}
