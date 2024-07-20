package Presenter.FamilyTreePresenter.Commands;

import Model.Interface.FamilyTreeInterface;
import Presenter.BaseClasses.Command;
import Presenter.Interface.Performing;
import View.Interface.FamilyTreeView;

public class sort_by_surname extends Command implements Performing {
    private final FamilyTreeView view;
    private final FamilyTreeInterface<?> familyTree;

    public sort_by_surname(FamilyTreeView view, FamilyTreeInterface<?> familyTree){
        super("sort by surname", "Сортировка по фамилии");

        this.familyTree = familyTree;
        this.view = view;
    }

    @Override
    public void execute() {
        this.familyTree.sortBySurname();

        this.view.printSignedMessage("Result", "Successful");
    }
}
