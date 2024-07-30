package Presenter.Commands.ForFamilyTree;

import Model.FamilyTree.Tree;
import Presenter.Commands.Command;
import Presenter.Commands.Performing;
import View.View;

public class sort_by_name extends Command implements Performing {
    private final View view;
    private final Tree familyTree;

    public sort_by_name(View view, Tree familyTree){
        super("sort by name", "Сортировка по имени");

        this.view = view;
        this.familyTree = familyTree;
    }

    @Override
    public void execute() {
        this.familyTree.sortByName();

        this.view.printMessage("Result", "Successful");
    }
}
