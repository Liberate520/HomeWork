package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class GetFamilyTree extends Command{

    public GetFamilyTree(ConsoleUI consoleUI){
        super("Найти члена семьи по имени", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getFamilyTree();
    }
}