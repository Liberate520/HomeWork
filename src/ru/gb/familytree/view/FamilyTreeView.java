package ru.gb.familytree.view;

import ru.gb.familytree.model.HumanInfo;
import ru.gb.familytree.presenter.FamilyTreePresenter;

import java.util.List;

public interface FamilyTreeView {
    void showFamilyTree(List<HumanInfo> familyTree);
    void showSuccess(String message);
    void showError(String message);
    void requestUserAction();
    void setPresenter(FamilyTreePresenter presenter);
}