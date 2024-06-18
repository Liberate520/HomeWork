package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

import java.io.IOException;

public class GetFamilyTreeInfo extends Command{
    public GetFamilyTreeInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Показать дерево";
    }


    public void execute() throws IOException, ClassNotFoundException {
        consoleUI.getFamilyTreeInfo();
    }
}
