package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class GetFamilyTreeInfoCommand  extends Command {

    public GetFamilyTreeInfoCommand(ConsoleUI consoleUI) {
        super("Показать список всех людей в древе", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getFamilyTreeInfo();
    }
}