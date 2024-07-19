package com.example.familytree.commands;

import com.example.familytree.mvp.FamilyTreePresenter;

public class DisplayTreeCommand implements Command {
    private final FamilyTreePresenter presenter;

    public DisplayTreeCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.displayTree();
    }

    @Override
    public String getDescription() {
        return "Демонстрация фамильного дерева";
    }
}
