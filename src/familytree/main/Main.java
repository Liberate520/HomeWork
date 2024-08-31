package familytree.main;

import familytree.factory.CommandFactory;
import familytree.factory.CommandFactoryInterface;
import familytree.io.FileDataHandler;
import familytree.model.FamilyTree;
import familytree.model.Person;
import familytree.presenter.FamilyTreePresenter;
import familytree.service.*;
import familytree.ui.ConsoleUserInterface;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();
        FileDataHandler fileDataHandler = new FileDataHandler();

        MemberManagerInterface memberManager = new MemberManager();
        RelationshipManagerInterface relationshipManager = new RelationshipManager(familyTree);
        DataManagerInterface dataManager = new DataManager(fileDataHandler, familyTree);

        FamilyTreeServiceInterface familyTreeService = new FamilyTreeService(memberManager, relationshipManager, dataManager);

        ConsoleUserInterface ui = new ConsoleUserInterface();
        CommandFactoryInterface commandFactory = new CommandFactory(familyTreeService, ui);
        FamilyTreePresenter presenter = new FamilyTreePresenter(familyTreeService, ui, commandFactory);

        presenter.start();
    }
}