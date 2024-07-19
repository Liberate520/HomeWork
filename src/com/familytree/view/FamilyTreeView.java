package com.familytree.view;

import com.familytree.model.Human;

import java.util.List;

public interface FamilyTreeView {
    void showPeople(List<Human> people);
    void showError(String message);
}
