package ru.gb.family_tree.view.command;

import ru.gb.family_tree.view.ConsoleUI;

public class GetChildrenInfoCommand extends Command {
    public GetChildrenInfoCommand(ConsoleUI consoleUI) {
        super("Построть фамильное древо человека.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getChildrenInfo();
    }
}