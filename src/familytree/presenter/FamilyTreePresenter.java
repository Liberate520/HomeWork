package familytree.presenter;

import familytree.model.human.Human;
import familytree.model.human.Gender;
import familytree.model.family_tree.FamilyTree;
import familytree.model.util.FileHandler;
import familytree.view.IFamilyTreeView;
import familytree.service.FamilyTreeService;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;


public class FamilyTreePresenter implements IFamilyTreePresenter {  
   private FamilyTreeService familyTreeService;
   private IFamilyTreeView view;
   

    public FamilyTreePresenter(IFamilyTreeView view) {
        this.view = view;
        this.familyTreeService = new FamilyTreeService();       
    }
  
    @Override
    public void loadFamilyTree() {      
        familyTreeService.loadFamilyTree();
        view.displayMessage("Family tree loaded from file");
    }

    @Override
    public void saveFamilyTree() {       
        familyTreeService.saveFamilyTree();
        view.displayMessage("Family tree saved to file");
    }

    @Override
    public void displayFamilyTree() {       
        view.displayFamilyTree(familyTreeService.displayFamilyTree());
    }

    @Override
    public void sortByName() {
        familyTreeService.sortByName();
        view.displaySortedTreeByName(familyTreeService.displayFamilyTree());
    }

    @Override
    public void sortByAge() {
        familyTreeService.sortByAge();
        view.displaySortedTreeByAge(familyTreeService.displayFamilyTree()); 
    }

    @Override
    public void createFamilyTree() {
        familyTreeService.createFamilyTree();
        view.displayMessage("Family tree created");
    }

    @Override
    public void addHumanToTree(String name, String gender, String birthDateStr, String deathDateStr) {
        try {
            familyTreeService.addHuman(name, gender, birthDateStr, deathDateStr);
            view.displayMessage("New human added to the family tree");
        } catch (DateTimeParseException | IllegalArgumentException e) {
            view.displayMessage("Error: Invalid data format");
        }
    }

    @Override
    public void addParentToChild(String childName, String parentName) {
        try {
            familyTreeService.addParentToChild(childName, parentName);
            view.displayMessage("Parent added to child successfully.");
        } catch (IllegalArgumentException e) {
            view.displayMessage("Error: " + e.getMessage());
        }
    }

    @Override
    public void addChildToParent(String parentName, String childName) {
        try {
            familyTreeService.addChildToParent(parentName, childName);
            view.displayMessage("Child added to parent successfully.");
        } catch (IllegalArgumentException e) {
            view.displayMessage("Error: " + e.getMessage());
        }
    }
}
