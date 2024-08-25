package Homework4_OOP;

import Homework4_OOP.FamilyTrees.FamilyTree;
import Homework4_OOP.Human.Human;
import Homework4_OOP.MVP.Presenter;
import Homework4_OOP.WritersClasses.UserInterface;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Human> tree = new FamilyTree<>();
        UserInterface ui = new UserInterface();
        Presenter presenter = new Presenter(ui, tree);
        presenter.start();
    }
}
