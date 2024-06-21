package ru.gb.family.view.command.editItemTree;

import ru.gb.family.model.familyTree.ItemFamilyTrees.enums.DegreeOfKinship;
import ru.gb.family.view.ConsoleUI;
import ru.gb.family.view.command.Command;

public class CommandEditItemAddCildren extends Command {
    public CommandEditItemAddCildren(ConsoleUI consoleUI) {
        super("Изменить степень родства члена дерева", consoleUI);
    }

    @Override
    public void run() {
        getConsoleUI().editItem(DegreeOfKinship.Children);
    }
}
