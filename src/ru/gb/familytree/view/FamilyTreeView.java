package ru.gb.familytree.view;

import ru.gb.familytree.model.HumanInfo;

import java.util.List;

public interface FamilyTreeView {
    void showFamilyTree(List<HumanInfo> members);
    void showError(String message);
    void showSuccess(String message);
}