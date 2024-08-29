package Homework6_OOP.Presenters;

import Homework6_OOP.Human.Human;
import Homework6_OOP.Services.FamilyTreeService;
import Homework6_OOP.WritersClasses.UserInterface;

import java.util.List;

public class Presenter implements ActionHandler {
    private final UserInterface ui;
    private final FamilyTreeService service;

    public Presenter(UserInterface ui, FamilyTreeService service) {
        this.ui = ui;
        this.service = service;
    }

    public void start() {
        while (true) {
            ui.printMenu();
            int choice = ui.getUserChoice();
            handleAction(choice);

            if (choice == 9) {
                break;
            }
        }
    }

    @Override
    public void handleAction(int choice) {
        switch (choice) {
            case 1 -> addHuman();
            case 2 -> searchByName();
            case 3 -> removeById();
            case 4 -> printTree();
            case 5 -> createParentChildRelationship();
            case 6 -> createMarriage();
            case 7 -> saveFamilyTree();
            case 8 -> loadFamilyTree();
            case 9 -> ui.exitMessage();
            default -> ui.printInvalidChoiceMessage();
        }
    }

    private void addHuman() {
        Human human = ui.getHumanDetails();
        service.addHuman(human);
        ui.printHumanAddedMessage();
    }

    private void searchByName() {
        String name = ui.getSearchQuery();
        List<Human> results = service.searchByName(name);
        ui.printSearchResults(results);
    }

    private void removeById() {
        long id = ui.getId();
        boolean removed = service.removeHumanById(id);
        if (removed) {
            ui.printHumanRemovedMessage();
        } else {
            ui.printHumanNotFoundMessage();
        }
    }

    private void printTree() {
        String treeInfo = service.getFamilyTreeInfo();
        ui.printFamilyTree(treeInfo);
    }

    private void createParentChildRelationship() {
        long parentId = ui.getParentId();
        long childId = ui.getChildId();
        boolean success = service.createFamilyRelationship(parentId, childId);
        if (success) {
            ui.printRelationshipCreatedMessage();
        } else {
            ui.printRelationshipFailureMessage();
        }
    }

    private void createMarriage() {
        long id1 = ui.getId1();
        long id2 = ui.getId2();
        boolean success = service.setWedding(id1, id2);
        if (success) {
            ui.printWeddingSuccessMessage();
        } else {
            ui.printWeddingFailureMessage();
        }
    }

    private void saveFamilyTree() {
        String filename = ui.getFilename();
        boolean success = service.saveFamilyTree(filename);
        if (success) {
            ui.printSaveSuccessMessage();
        } else {
            ui.printSaveFailureMessage();
        }
    }

    private void loadFamilyTree() {
        String filename = ui.getFilename();
        boolean success = service.loadFamilyTree(filename);
        if (success) {
            ui.printLoadSuccessMessage();
        } else {
            ui.printLoadFailureMessage();
        }
    }
}
