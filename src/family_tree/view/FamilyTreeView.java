package family_tree.view;
import java.util.List;
import family_tree.model.Human;

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