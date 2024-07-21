package View.Commands;

import Model.FamilyTree.FamilyTreeService.FamilyTreeService;
import Presenter.Presenter;
import View.Command;
import View.MainMenu;

public class ShowTree extends Command {

    public ShowTree() {
        super("Показать дерево");
    }

    @Override
    public void execute() {
        System.out.println("Семейное дерево:" + presenter.getFamilyTreeInfo());

    }

}
