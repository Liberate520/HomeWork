package Presenter.Commands.ForFamilyTree;

import Model.FamilyTree.Tree;
import Presenter.Commands.Command;
import Presenter.Commands.Performing;
import View.View;

public class sort_by_children extends Command implements Performing {
    private final View view;
    private final Tree familyTree;

    public sort_by_children(View view, Tree familyTree){
        super("sort by children", "Сортировка по количеству детей");

        this.familyTree = familyTree;
        this.view = view;
    }

    @Override
    public void execute() {
        this.familyTree.sortByChildren();

        this.view.printMessage("Result", "Successful");
    }
}
