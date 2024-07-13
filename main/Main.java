package main;

import model.FamilyTree;
import model.Person;
import model.io.FileHandlerImpl;
import model.services.FamilyTreeServiceImpl;
import presenter.FamilyTreePresenter;
import view.ConsoleView;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();
        FileHandlerImpl fileHandler = new FileHandlerImpl();
        FamilyTreeServiceImpl<Person> service = new FamilyTreeServiceImpl<>(familyTree, fileHandler);
        ConsoleView view = new ConsoleView();
        FamilyTreePresenter presenter = new FamilyTreePresenter(service, view);
        presenter.start();
    }
}
