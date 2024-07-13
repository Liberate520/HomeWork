package com.familytree.presenter;

import com.familytree.FamilyTree;
import com.familytree.model.Gender;
import com.familytree.model.Human;
import com.familytree.view.FamilyTreeView;

import java.time.LocalDate;

public class FamilyTreePresenter {
    private FamilyTree<Human> familyTree;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTreeView view) {
        this.view = view;
        this.familyTree = new FamilyTree<>();
    }

    public void addPerson(String name, LocalDate birthDate, Gender gender) {
        familyTree.addPerson(new Human(name, birthDate, gender));
    }

    public void setParents(String childName, String motherName, String fatherName) {
        familyTree.setParents(childName, motherName, fatherName);
    }

    public void showChildren(String personName) {
        view.showChildren(familyTree.getChildren(personName));
    }

    public void showPeopleSortedByName() {
        view.showPeopleSortedByName(familyTree.getPeopleSortedByName());
    }

    public void showPeopleSortedByBirthDate() {
        view.showPeopleSortedByBirthDate(familyTree.getPeopleSortedByBirthDate());
    }
}