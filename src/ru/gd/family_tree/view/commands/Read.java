package ru.gd.family_tree.view.commands;

import ru.gd.family_tree.view.ConsoleUI;

import java.io.IOException;

public class Read extends Commands{
    public Read(ConsoleUI consoleUI) {
        super(consoleUI,"Считать из файла");// description устанавливаем тут
    }

    @Override
    void execute() {
        try {
            getConsoleUI().readFamilyTree();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

