package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class GetFamilyTree extends Command{

    public GetFamilyTree(ConsoleUI consoleUI){
        super("Получить список семьи", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getFamilyTree();
    }
}