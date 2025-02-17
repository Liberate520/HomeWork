package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

import java.io.IOException;

public class FinishWork extends Command {

    public FinishWork(ConsoleUI consoleUI) {
        super("Выход из программы.", consoleUI);
    }

    @Override
    public void execute() throws IOException {
        getConsoleUI().finishWork();
    }
}
