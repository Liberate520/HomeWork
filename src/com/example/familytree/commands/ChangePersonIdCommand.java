package com.example.familytree.commands;

import com.example.familytree.mvp.FamilyTreePresenter;
import com.example.familytree.mvp.FamilyTreeView;

public class ChangePersonIdCommand implements Command {
    private final FamilyTreePresenter presenter;
    private final FamilyTreeView view;

    public ChangePersonIdCommand(FamilyTreePresenter presenter, FamilyTreeView view) {
        this.presenter = presenter;
        this.view = view;
    }

    @Override
    public void execute() {
        System.out.print("Введите старый ID: ");
        int oldId = view.getScanner().nextInt();
        view.getScanner().nextLine(); // consume newline
        System.out.print("Введите новый ID: ");
        int newId = view.getScanner().nextInt();
        view.getScanner().nextLine(); // consume newline
        presenter.changePersonId(oldId, newId);
    }

    @Override
    public String getDescription() {
        return "Изменение ID человека";
    }
}
