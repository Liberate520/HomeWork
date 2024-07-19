package com.example.familytree.commands;

import com.example.familytree.mvp.FamilyTreePresenter;
import com.example.familytree.mvp.FamilyTreeView;

public class SetParentChildRelationCommand implements Command {
    private final FamilyTreePresenter presenter;
    private final FamilyTreeView view;

    public SetParentChildRelationCommand(FamilyTreePresenter presenter, FamilyTreeView view) {
        this.presenter = presenter;
        this.view = view;
    }

    @Override
    public void execute() {
        int parentId = view.getParentIdInput();
        int childId = view.getChildIdInput();
        presenter.setParentChildRelation(parentId, childId);
    }

    @Override
    public String getDescription() {
        return "Установить связь родитель-ребенок";
    }
}
