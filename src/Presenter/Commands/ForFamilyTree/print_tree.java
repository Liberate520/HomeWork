package Presenter.Commands.ForFamilyTree;

import Model.FamilyTree.Tree;
import Presenter.Commands.Command;
import Presenter.Commands.Performing;
import View.View;

public class print_tree extends Command implements Performing {
    private final Tree familyTree;
    private final View view;

    public print_tree(View view, Tree familyTree){
        super("print tree", "Вывод всех существ в семейном древе");

        this.familyTree = familyTree;
        this.view = view;
    }

    @Override
    public void execute() {
        this.view.println(this.familyTree.toString());
    }
}
