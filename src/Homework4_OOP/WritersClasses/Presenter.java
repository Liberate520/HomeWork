package Homework4_OOP.WritersClasses;

import Homework4_OOP.Human.Human;
import Homework4_OOP.Services.FamilyTreeService;

import java.util.List;

public class Presenter {
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

            switch (choice) {
                case 1 -> addHuman();
                case 2 -> searchByName();
                case 3 -> removeById();
                case 4 -> printTree();
                case 5 -> createFamilyRelationship();
                case 6 -> setWedding();  // Новый случай для установления брака
                case 7 -> saveFamilyTree();
                case 8 -> loadFamilyTree();
                case 9 -> {
                    ui.exitMessage();
                    return;
                }
                default -> ui.printInvalidChoiceMessage();
            }
        }
    }

    private void addHuman() {
        Human human = ui.getHumanDetails();
        service.addHuman(human);
        ui.printHumanAddedMessage();
    }

    private void searchByName() {
        String name = ui.getSearchName();
        List<Human> results = service.searchByName(name);
        ui.printSearchResults(results);
    }
    private void setWedding() {
        long id1 = ui.getFirstSpouseId();
        long id2 = ui.getSecondSpouseId();
        boolean success = service.setWedding(id1, id2);
        ui.printWeddingResult(success);
    }

    private void removeById() {
        long id = ui.getIdToRemove();
        boolean result = service.removeHumanById(id);
        ui.printRemoveResult(result);
    }

    private void printTree() {
        ui.printTree(service.getFamilyTreeInfo());
    }

    private void createFamilyRelationship() {
        long parentId = ui.getParentId();
        long childId = ui.getChildId();
        service.createFamilyRelationship(parentId, childId);
        ui.printFamilyRelationshipCreatedMessage();
    }

    private void saveFamilyTree() {
        String filename = ui.getFilenameToSave();
        boolean success = service.saveFamilyTree(filename);
        ui.printSaveResult(success);
    }

    private void loadFamilyTree() {
        String filename = ui.getFilenameToLoad();
        boolean success = service.loadFamilyTree(filename);
        ui.printLoadResult(success);
    }
}
