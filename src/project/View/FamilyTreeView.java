package project.View;
// public interface FamilyTreeView {
//     void displayFamilyTree(FamilyTree<Human> familyTree);
//     void displayMessage(String message);
//     void displayError(String error);
// }

import java.util.List;

import project.Members.TreeMember;

public interface FamilyTreeView {
    void displayMemberDescriptions(List<String> descriptions);
    void displayMessage(String message);
    void displayChildren(List<TreeMember> children);
    void start();
}
