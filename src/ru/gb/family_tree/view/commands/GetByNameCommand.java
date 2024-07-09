package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.model.service.FamilyTreeService;
import ru.gb.family_tree.view.View;
import ru.gb.family_tree.model.family_tree.TreeNode;

import java.util.List;

public class GetByNameCommand<E extends TreeNode<E>> implements Command {
    private final FamilyTreeService<E> familyTreeService;
    private final View view;

    public GetByNameCommand(FamilyTreeService<E> familyTreeService, View view) {
        this.familyTreeService = familyTreeService;
        this.view = view;
    }

    @Override
    public void execute() {
        String name = view.getInput("Введите имя человека: ");
        List<E> humans = familyTreeService.getByName(name);
        if (!humans.isEmpty()) {
            view.displayList(humans, "Люди с именем " + name + ":");
        } else {
            view.displayMessage("Люди с именем " + name + " не найдены.");
        }
    }
}

