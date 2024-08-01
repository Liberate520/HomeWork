package ru.gb2.family_tree7.view;

public interface FamilyTreeView {
    void displayMenu();
    void showFamilyMembers(List<Human> familyMembers);
    void showMemberDetails(Human member);
    void showMessage(String message);
    String getInput(String prompt);
}
