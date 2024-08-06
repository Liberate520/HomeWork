package ru.gb.family_tree.view;

import ru.gb.family_tree.models.Human;

import java.util.List;

public interface FamilyTreeView {
    void showMessage(String message);
    void showAllMembers(List<Human> members);
    void showMember(Human member);
    String getUserInput(String prompt);
}
