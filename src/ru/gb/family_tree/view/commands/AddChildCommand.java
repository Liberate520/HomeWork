package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.model.family_tree.TreeNodeImpl;
import ru.gb.family_tree.model.service.FamilyTreeService;
import ru.gb.family_tree.view.View;

public class AddChildCommand implements Command {
    private final FamilyTreeService<TreeNodeImpl> familyTreeService;
    private final View view;

    public AddChildCommand(FamilyTreeService<TreeNodeImpl> familyTreeService, View view) {
        this.familyTreeService = familyTreeService;
        this.view = view;
    }

    @Override
    public void execute() {
        long parentId = view.promptForInt("Введите ID родителя:");
        long childId = view.promptForInt("Введите ID ребенка:");

        TreeNodeImpl parent = familyTreeService.getById(parentId);
        TreeNodeImpl child = familyTreeService.getById(childId);

        if (parent != null && child != null) {
            parent.addChild(child);
            child.addParent(parent);
            view.displayMessage("Ребенок успешно добавлен.");
        } else {
            view.displayMessage("Ошибка: Неверный ID.");
        }
    }
}
