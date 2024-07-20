package Presenter.FamilyTreePresenter.Commands;

import Model.Interface.FamilyTreeInterface;
import Presenter.BaseClasses.Command;
import Presenter.Interface.Performing;
import View.Interface.FamilyTreeView;

public class sort_by_ID extends Command implements Performing {
    private final FamilyTreeView view;
    private final FamilyTreeInterface<?> familyTree;

    public sort_by_ID(FamilyTreeView view, FamilyTreeInterface<?> familyTree){
        super("sort by ID", "Сортировка по ID существа");

        this.familyTree = familyTree;
        this.view = view;
    }

    @Override
    public void execute() {
        this.familyTree.sortByID();

        this.view.printSignedMessage("Result", "Successful");
    }
}
