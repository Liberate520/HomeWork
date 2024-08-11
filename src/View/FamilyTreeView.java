package View;

import java.util.List;

import Model.Human;

public interface FamilyTreeView {
    void displayFamilyTree(List<Human> familyMembers);

    String getNameForChildren();

    String getNameForParents();

    void displayChildren(String name, List<Human> children);

    void displayParents(String name, List<Human> parents);

    void displayMessage(String message);
}
