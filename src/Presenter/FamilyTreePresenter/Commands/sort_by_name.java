package Presenter.FamilyTreePresenter.Commands;

import Model.Interface.FamilyTreeInterface;
import Presenter.BaseClasses.Command;
import Presenter.Interface.Performing;
import View.Interface.FamilyTreeView;

public class sort_by_name extends Command implements Performing {
    private final FamilyTreeView view;
    private final FamilyTreeInterface<?> familyTree;

    public sort_by_name(FamilyTreeView view, FamilyTreeInterface<?> familyTree){
        super("sort by name", "Сортировка по имени");

        this.view = view;
        this.familyTree = familyTree;
    }

    @Override
    public void execute() {
        this.familyTree.sortByName();

        this.view.printSignedMessage("Result", "Successful");
    }
}
