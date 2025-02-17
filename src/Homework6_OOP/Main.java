package Homework6_OOP;

import Homework6_OOP.FamilyTrees.FamilyTree;
import Homework6_OOP.Services.FamilyTreeService;
import Homework6_OOP.Presenters.Presenter;
import Homework6_OOP.WritersClasses.FileHandler;
import Homework6_OOP.WritersClasses.UserInterface;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        FileHandler fileHandler = new FileHandler();
        FamilyTreeService service = new FamilyTreeService(familyTree, fileHandler);
        UserInterface ui = new UserInterface();

        Presenter presenter = new Presenter(ui, service);


        presenter.start();
    }
}
