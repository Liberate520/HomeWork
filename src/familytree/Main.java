package familytree;

import familytree.model.human.Human;
import familytree.model.human.Gender;
import familytree.model.family_tree.FamilyTree;
import familytree.model.util.FileHandler;
import familytree.presenter.FamilyTreePresenter;
import familytree.presenter.IFamilyTreePresenter;
import familytree.menu.ConsoleMenu;
import familytree.view.IFamilyTreeView;
import familytree.view.FamilyTreeView;


import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        IFamilyTreeView view = new FamilyTreeView();
        IFamilyTreePresenter presenter = new FamilyTreePresenter(view);
        ConsoleMenu menu = new ConsoleMenu(presenter);

        //Создать дерево
        presenter.createFamilyTree();
 
        // Меню
        menu.displayMenu();
    }
}
