package ru.gb.family.view.command.editItemTree;

import ru.gb.family.model.familyTree.ItemFamilyTrees.enums.DegreeOfKinship;
import ru.gb.family.view.ConsoleUI;
import ru.gb.family.view.command.Command;

public class CommandAddParent extends Command {
    public CommandAddParent(ConsoleUI consoleUI) {
        super("Добавить родителя", consoleUI);
    }

    @Override
    public void run() {
        getConsoleUI().editItemParent(DegreeOfKinship.Father);
    }
}
