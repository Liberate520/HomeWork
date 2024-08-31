package familytree.main;

import familytree.factory.CommandFactory;
import familytree.factory.CommandFactoryInterface;
import familytree.io.FileDataHandler;
import familytree.model.FamilyTree;
import familytree.model.Person;
import familytree.presenter.FamilyTreePresenter;
import familytree.service.*;
import familytree.ui.ConsoleUserInterface;
import familytree.ui.MenuProvider;
import familytree.ui.MenuProviderInterface;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Person> familyTree = new FamilyTree<>();
        FileDataHandler fileDataHandler = new FileDataHandler();

        MemberManagerInterface memberManager = new MemberManager();
        RelationshipManagerInterface relationshipManager = new RelationshipManager(familyTree);
        DataManagerInterface dataManager = new DataManager(fileDataHandler, familyTree);

        FamilyTreeServiceInterface familyTreeService = new FamilyTreeService(memberManager, relationshipManager, dataManager);
        MenuProviderInterface menuProvider = new MenuProvider();
        ConsoleUserInterface ui = new ConsoleUserInterface(menuProvider);

        CommandFactoryInterface commandFactory = new CommandFactory(familyTreeService, ui);
        FamilyTreePresenter presenter = new FamilyTreePresenter(familyTreeService, ui, commandFactory);

        presenter.start();
    }
}