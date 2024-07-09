package ru.gd.family_tree.model.commands;

import ru.gd.family_tree.view.ConsoleUI;

import java.io.IOException;

public class Save extends Commands{
    public Save(ConsoleUI consoleUI) {
        super(consoleUI,"Сохранить дерево в файл ");// description устанавливаем тут
    }

    @Override
    void execute() {
        try {
            getConsoleUI().saveFamilyTree();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

