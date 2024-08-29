package ru.gb.family_tree.view.command;

import ru.gb.family_tree.view.ConsoleUI;

public class GetTreeInfoCommand extends Command{
    public GetTreeInfoCommand(ConsoleUI consoleUI) {
        super("Вывести список людей входящих в семейное древо.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getTreeInfo();
    }
}
