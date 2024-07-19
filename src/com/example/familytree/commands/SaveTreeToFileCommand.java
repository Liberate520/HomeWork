package com.example.familytree.commands;

import com.example.familytree.mvp.FamilyTreePresenter;
import com.example.familytree.mvp.FamilyTreeView;

public class SaveTreeToFileCommand implements Command {
    private final FamilyTreePresenter presenter;
    private final FamilyTreeView view;

    public SaveTreeToFileCommand(FamilyTreePresenter presenter, FamilyTreeView view) {
        this.presenter = presenter;
        this.view = view;
    }

    @Override
    public void execute() {
        System.out.print("Введите имя файла: ");
        String saveFilename = view.getScanner().nextLine();
        presenter.saveToFile(saveFilename);
    }

    @Override
    public String getDescription() {
        return "Сохранение фамильного дерева в файл";
    }
}
