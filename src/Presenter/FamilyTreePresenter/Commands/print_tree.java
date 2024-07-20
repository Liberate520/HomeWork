package Presenter.FamilyTreePresenter.Commands;

import Model.Interface.FamilyTreeInterface;
import Presenter.BaseClasses.Command;
import Presenter.Interface.Performing;
import View.Interface.FamilyTreeView;

public class print_tree extends Command implements Performing {
    private final FamilyTreeInterface<?> familyTree;
    private final FamilyTreeView view;

    public print_tree(FamilyTreeView view, FamilyTreeInterface<?> familyTree){
        super("print tree", "Вывод всех существ в семейном древе");

        this.familyTree = familyTree;
        this.view = view;
    }

    @Override
    public void execute() {
        this.view.println(this.familyTree.toString());
    }
}
