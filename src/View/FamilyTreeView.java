package View;

import java.util.List;

import Model.Human;

public interface FamilyTreeView<T extends Human> {
    void displayFamilyTree(List<T> familyMembers);

    String getNameForChildren();

    String getNameForParents();

    void displayChildren(String name, List<T> children);

    void displayParents(String name, List<T> parents);

    void displayMessage(String message);

    void displayMenu();
}
