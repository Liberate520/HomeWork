package com.example.familytree.commands;

import com.example.familytree.mvp.FamilyTreePresenter;

public class SortByBirthDateCommand implements Command {
    private final FamilyTreePresenter presenter;

    public SortByBirthDateCommand(FamilyTreePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void execute() {
        presenter.sortByBirthDate();
    }

    @Override
    public String getDescription() {
        return "Сортировка по дате рождения";
    }
}
