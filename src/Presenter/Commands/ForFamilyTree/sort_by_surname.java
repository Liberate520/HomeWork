package Presenter.Commands.ForFamilyTree;

import Model.FamilyTree.Tree;
import Presenter.Commands.Command;
import Presenter.Commands.Performing;
import View.View;

public class sort_by_surname extends Command implements Performing {
    private final View view;
    private final Tree familyTree;

    public sort_by_surname(View view, Tree familyTree){
        super("sort by surname", "Сортировка по фамилии");

        this.familyTree = familyTree;
        this.view = view;
    }

    @Override
    public void execute() {
        this.familyTree.sortBySurname();

        this.view.printMessage("Result", "Successful");
    }
}
