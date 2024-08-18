package ru.gb.family.view.command.start;

import ru.gb.family.view.ConsoleUI;
import ru.gb.family.view.command.Command;

public class CommandNewTree extends Command {

    public CommandNewTree(ConsoleUI consoleUI) {
        super("Добавить новое семейное древо", consoleUI);
    }


    @Override
    public void run() {
        getConsoleUI().newTree();
    }
}
