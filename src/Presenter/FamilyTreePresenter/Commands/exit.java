package Presenter.FamilyTreePresenter.Commands;

import Presenter.BaseClasses.Command;
import View.Interface.FamilyTreeView;

public class exit extends Command {
    private final FamilyTreeView familyTreeView;

    public exit(FamilyTreeView treeView){
        super("exit", "Выход из программы");
        this.familyTreeView = treeView;
    }

    @Override
    public void execute() {
        this.familyTreeView.exit();
    }
}
