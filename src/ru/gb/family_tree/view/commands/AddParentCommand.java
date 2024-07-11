package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.model.family_tree.TreeNodeImpl;
import ru.gb.family_tree.model.service.FamilyTreeService;
import ru.gb.family_tree.view.View;

public class AddParentCommand implements Command {
    private final FamilyTreeService<TreeNodeImpl> familyTreeService;
    private final View view;

    public AddParentCommand(FamilyTreeService<TreeNodeImpl> familyTreeService, View view) {
        this.familyTreeService = familyTreeService;
        this.view = view;
    }

    @Override
    public void execute() {
        long childId = view.promptForInt("Введите ID ребенка:");
        long parentId = view.promptForInt("Введите ID родителя:");

        TreeNodeImpl child = familyTreeService.getById(childId);
        TreeNodeImpl parent = familyTreeService.getById(parentId);

        if (child != null && parent != null) {
            child.addParent(parent);
            parent.addChild(child);
            view.displayMessage("Родитель успешно добавлен.");
        } else {
            view.displayMessage("Ошибка: Неверный ID.");
        }
    }
}
