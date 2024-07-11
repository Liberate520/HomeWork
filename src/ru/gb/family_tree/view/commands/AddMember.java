package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class AddMember extends Commands{

    public AddMember(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить участника дерева.";
    }

    @Override
    public void execute() {
        consoleUI.addMember();
    }
}
