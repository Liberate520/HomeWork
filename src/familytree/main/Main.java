package familytree.main;

import familytree.factory.PersonFactory;
import familytree.io.FileDataHandler;
import familytree.model.FamilyTree;
import familytree.model.Person;
import familytree.presenter.FamilyTreePresenter;
import familytree.service.FamilyTreeService;
import familytree.ui.ConsoleUserInterface;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();
        FileDataHandler fileDataHandler = new FileDataHandler();
        PersonFactory personFactory = new PersonFactory();
        FamilyTreeService familyTreeService = new FamilyTreeService(familyTree, fileDataHandler,personFactory);
        ConsoleUserInterface ui = new ConsoleUserInterface();

        FamilyTreePresenter presenter = new FamilyTreePresenter(familyTreeService, ui);
        while (true) {
            presenter.handleUserInput();
        }
    }
}