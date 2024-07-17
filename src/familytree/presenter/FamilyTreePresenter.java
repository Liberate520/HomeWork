package familytree.presenter;

import familytree.model.FamilyTree;
import familytree.model.Human;
import familytree.sort.Sorter;
import familytree.view.FamilyTreeView;
import familytree.writer.Writer;

import java.util.List;

public class FamilyTreePresenter {
    private FamilyTree familyTree;
    private FamilyTreeView view;
    private Writer writer;

    public FamilyTreePresenter(FamilyTree familyTree, FamilyTreeView view, Writer writer) {
        this.familyTree = familyTree;
        this.view = view;
        this.writer = writer;
    }

    public void saveTree(String filePath) {
        writer.setPath(filePath);
        writer.save(familyTree);
        view.displayMessage("Family tree saved to " + filePath);
    }

    public void loadTree(String filePath) {
        writer.setPath(filePath);
        this.familyTree = (FamilyTree) writer.read();
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