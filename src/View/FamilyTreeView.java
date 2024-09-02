package View;

import java.util.List;

public interface FamilyTreeView<T> {
    void displayFamilyTree(List<T> familyMembers);

    String getNameForChildren();

    String getNameForParents();

    void displayChildren(String name, List<T> children);

    void displayParents(String name, List<T> parents);

    void displayMessage(String message);

    void displayMenu();
}
