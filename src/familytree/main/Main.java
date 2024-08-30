package familytree.main;

import familytree.factory.PersonFactory;
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
        PersonFactory personFactory = new PersonFactory();

        MemberManagerInterface memberManager = new MemberManager();
        RelationshipManagerInterface relationshipManager = new RelationshipManager(familyTree);
        DataManagerInterface dataManager = new DataManager(fileDataHandler, familyTree);

        MemberService memberService = new MemberService();
        RelationshipService relationshipService = new RelationshipService(memberService);
        DataService dataService = new DataService(memberService);

        ConsoleUserInterface ui = new ConsoleUserInterface();
        FamilyTreeService familyTreeService = new FamilyTreeService(memberManager, relationshipManager, dataManager);

        memberManager.updateFamilyTree(familyTree);

        FamilyTreePresenter presenter = new FamilyTreePresenter(familyTreeService, ui);

        while (true) {
            presenter.handleUserInput();
        }
    }
}