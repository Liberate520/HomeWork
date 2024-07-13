package com.familytree.view;

import com.familytree.model.Human;

import java.util.List;

public interface FamilyTreeView {
    void showChildren(List<Human> children);
    void showPeopleSortedByName(List<Human> people);
    void showPeopleSortedByBirthDate(List<Human> people);
}
