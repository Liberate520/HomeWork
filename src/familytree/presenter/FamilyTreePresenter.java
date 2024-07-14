package familytree.presenter;

import familytree.model.FamilyTree;
import familytree.model.Human;
import familytree.sort.Sorter;
import familytree.view.FamilyTreeView;

import java.util.List;

public class FamilyTreePresenter {
    private FamilyTree familyTree;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTree familyTree, FamilyTreeView view) {
        this.familyTree = familyTree;
        this.view = view;
    }

    public void saveTree(String filePath) {
        familyTree.save(filePath);
        view.displayMessage("Family tree saved to " + filePath);
    }

    public void loadTree(String filePath) {
        this.familyTree = FamilyTree.read(filePath);
        view.displayMessage("Family tree loaded from " + filePath);
    }

    public void displayHumanDetails(String name) {
        Human human = familyTree.findHumanByName(name);
        if (human != null) {
            view.displayHumanDetails(human);
        } else {
            view.displayMessage("Human not found.");
        }
    }

    public void sortAndDisplayByName() {
        Sorter.sortByName(familyTree.getPeople());
        view.displayMessage("Sorted by name:");
        view.displayHumanList(familyTree.getPeople());
    }

    public void sortAndDisplayByBirthDate() {
        Sorter.sortByBirthDate(familyTree.getPeople());
        view.displayMessage("Sorted by birth date:");
        view.displayHumanList(familyTree.getPeople());
    }
}