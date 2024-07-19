package com.example.familytree.commands;

import com.example.familytree.mvp.FamilyTreePresenter;
import com.example.familytree.mvp.FamilyTreeView;

public class RemovePersonCommand implements Command {
    private final FamilyTreePresenter presenter;
    private final FamilyTreeView view;

    public RemovePersonCommand(FamilyTreePresenter presenter, FamilyTreeView view) {
        this.presenter = presenter;
        this.view = view;
    }

    @Override
    public void execute() {
        int removeId = view.getPersonIdInput();
        presenter.removePersonById(removeId);
    }

    @Override
    public String getDescription() {
        return "Удаление человека по ID";
    }
}
