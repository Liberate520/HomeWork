package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.model.family_tree.TreeNode;
import ru.gb.family_tree.model.service.FamilyTreeService;
import ru.gb.family_tree.view.View;

public class SortByBirthDateCommand<E extends TreeNode<E>> implements Command {
    private final FamilyTreeService<E> familyTreeService;
    private final View view;

    public SortByBirthDateCommand(FamilyTreeService<E> familyTreeService, View view) {
        this.familyTreeService = familyTreeService;
        this.view = view;
    }

    @Override
    public void execute() {
        familyTreeService.sortByBirthDate();
        view.displayMessage("Список отсортирован по дате рождения.");
    }
}
