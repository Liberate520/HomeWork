package Main;

import Model.FamilyTree;
import Model.Person;
import Presenter.FamilyTreePresenter;
import Service.FamilyTreeService;
import Util.FileManager;
import View.ConsoleView;
import View.FamilyTreeView;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();
        FileManager fileManager = new FileManager();
        FamilyTreeService service = new FamilyTreeService(familyTree, fileManager);
        ConsoleView consoleView = new ConsoleView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(service, (FamilyTreeView) consoleView);

        presenter.start();
    }
}

