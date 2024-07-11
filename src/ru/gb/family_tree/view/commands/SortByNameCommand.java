package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.model.family_tree.TreeNode;
import ru.gb.family_tree.model.service.FamilyTreeService;
import ru.gb.family_tree.view.View;

public class SortByNameCommand<E extends TreeNode<E>> implements Command {
    private final FamilyTreeService<E> familyTreeService;
    private final View view;

    public SortByNameCommand(FamilyTreeService<E> familyTreeService, View view) {
        this.familyTreeService = familyTreeService;
        this.view = view;
    }

    @Override
    public void execute() {
        familyTreeService.sortByName();
        view.displayMessage("Список отсортирован по имени.");
    }
}
