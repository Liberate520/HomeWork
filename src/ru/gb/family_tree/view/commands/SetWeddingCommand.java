package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.model.service.FamilyTreeService;
import ru.gb.family_tree.view.View;
import ru.gb.family_tree.model.family_tree.TreeNode;

public class SetWeddingCommand<E extends TreeNode<E>> implements Command {
    private final FamilyTreeService<E> familyTreeService;
    private final View view;

    public SetWeddingCommand(FamilyTreeService<E> familyTreeService, View view) {
        this.familyTreeService = familyTreeService;
        this.view = view;
    }

    @Override
    public void execute() {
        long id1 = view.getLongInput("Введите ID первого человека: ");
        long id2 = view.getLongInput("Введите ID второго человека: ");
        if (familyTreeService.setWedding(id1, id2)) {
            view.displayMessage("Брак установлен.");
        } else {
            view.displayMessage("Не удалось установить брак.");
        }
    }
}
