package family_tree.view;

import family_tree.model.Human;
import java.util.List;

public interface FamilyTreeView {
    void displaySortedTree(List<Human> sortedTree);
    void displayErrorMessage(String message);
    void displayHumanDetails(Human human);
    void displayUnsortedTree(List<Human> unsortedTree);
    void displayMessage(String message);
    void displaySaveSuccessMessage(String message);
    void displaySaveErrorMessage(String message);
    void displayLoadSuccessMessage(String message);
    void displayLoadErrorMessage(String message);
}
