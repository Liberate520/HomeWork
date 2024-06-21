package ru.gb.family.view.command.start;

import ru.gb.family.view.ConsoleUI;
import ru.gb.family.view.command.Command;

public class CommandOpenTree extends Command {

    public CommandOpenTree(ConsoleUI consoleUI) {
        super("Загрузить ранее созданое", consoleUI);
    }

    @Override
    public void run() {
        getConsoleUI().loadTree();
    }

}
