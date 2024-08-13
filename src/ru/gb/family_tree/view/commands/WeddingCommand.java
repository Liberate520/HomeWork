package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class WeddingCommand extends Command {

    public WeddingCommand(ConsoleUI consoleUI) {
        super("Свадьба", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().addWedding();
    }
}
