package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.model.family_tree.TreeNode;
import ru.gb.family_tree.model.service.FamilyTreeService;
import ru.gb.family_tree.view.View;

public class RemoveHumanCommand<E extends TreeNode<E>> implements Command {
    private final FamilyTreeService<E> familyTreeService;
    private final View view;

    public RemoveHumanCommand(FamilyTreeService<E> familyTreeService, View view) {
        this.familyTreeService = familyTreeService;
        this.view = view;
    }

    @Override
    public void execute() {
        long id = view.promptForInt("Введите ID человека: ");
        if (familyTreeService.removeHuman(id)) {
            view.displayMessage("Человек удален.");
        } else {
            view.displayMessage("Не удалось удалить человека или неверный ID.");
        }
    }
}
