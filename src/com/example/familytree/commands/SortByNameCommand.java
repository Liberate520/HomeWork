package com.example.familytree.commands;

import com.example.familytree.mvp.FamilyTreePresenter;

public class SortByNameCommand implements Command {
    private final FamilyTreePresenter presenter;

    public SortByNameCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.sortByName();
    }

    @Override
    public String getDescription() {
        return "Сортировка по имени";
    }
}
