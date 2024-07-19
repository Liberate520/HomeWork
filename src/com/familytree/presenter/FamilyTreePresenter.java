package com.familytree.presenter;

import com.familytree.FamilyTree;
import com.familytree.model.Gender;
import com.familytree.utils.FamilyTreeSerializer;
import com.familytree.view.FamilyTreeView;
import com.familytree.model.Human;

import java.time.LocalDate;
import java.util.List;

public class FamilyTreePresenter {
    private FamilyTree familyTree;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyTreeView view) {
        this.view = view;
        this.familyTree = new FamilyTree();
    }

    public void addPerson(String name, LocalDate dob, Gender gender) {
        familyTree.addPerson(name, dob, gender);
    }

    public void setParents(String childName, String motherName, String fatherName) {
        familyTree.setParents(childName, motherName, fatherName);
    }

    public void showChildren(String personName) {
        List<Human> children = familyTree.getChildren(personName);
        view.showPeople(children);
    }

    public void showPeopleSortedByName() {
        List<Human> people = familyTree.getPeopleSortedByName();
        view.showPeople(people);
    }

    public void showPeopleSortedByBirthDate() {
        List<Human> people = familyTree.getPeopleSortedByBirthDate();
        view.showPeople(people);
    }

    public void saveFamilyTree(String filename) {
        FamilyTreeSerializer.saveToFile(familyTree, filename);
    }

    public void loadFamilyTree(String filename) {
        FamilyTree loadedFamilyTree = FamilyTreeSerializer.loadFromFile(filename);
        if (loadedFamilyTree != null) {
            this.familyTree = loadedFamilyTree;
        } else {
            view.showError("Failed to load family tree.");
        }
    }
}