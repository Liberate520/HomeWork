package com.example.familytree.commands;

import com.example.familytree.mvp.FamilyTreePresenter;
import com.example.familytree.mvp.FamilyTreeView;

public class LoadTreeFromFileCommand implements Command {
    private final FamilyTreePresenter presenter;
    private final FamilyTreeView view;

    public LoadTreeFromFileCommand(FamilyTreePresenter presenter, FamilyTreeView view) {
        this.presenter = presenter;
        this.view = view;
    }

    @Override
    public void execute() {
        System.out.print("Введите имя файла: ");
        String loadFilename = view.getScanner().nextLine();
        presenter.loadFromFile(loadFilename);
    }

    @Override
    public String getDescription() {
        return "Загрузка фамильного дерева из файла";
    }
}
