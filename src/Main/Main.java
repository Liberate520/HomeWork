package Main;

import Model.FamilyTree;
import Model.Person;
import Presenter.FamilyTreePresenter;
import Util.FileManager;
import View.ConsoleView;
import View.FamilyTreeView;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();
        FileManager fileManager = new FileManager();
        ConsoleView consoleView = new ConsoleView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(familyTree, fileManager, (FamilyTreeView) consoleView);

        presenter.start();
    }
}

