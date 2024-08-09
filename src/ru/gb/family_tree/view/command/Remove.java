package ru.gb.family_tree.view.command;

import ru.gb.family_tree.view.ConsoleUI;

public class Remove extends Command{
    public Remove(ConsoleUI consoleUI) {
        super("Удаление человека из семейного древа.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().remove();
    }
}
