package com.example.familytree.mvp;

import com.example.familytree.model.Person;
import com.example.familytree.operations.FileOperations;
import com.example.familytree.FamilyTree; // Импортируем FamilyTree

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Service {
    private final FamilyTree<Person> familyTree;
    private final FamilyTreePresenterImpl presenter;
    private final FamilyTreeView view;
    private final FileOperations fileOps;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public Service(FamilyTreeView view, FileOperations fileOps) {
        this.view = view;
        this.fileOps = fileOps;
        this.familyTree = new FamilyTree<>();
        this.presenter = new FamilyTreePresenterImpl(view, fileOps);
        presenter.setFamilyTree(familyTree);
    }

    public void addPerson(int id, String name, String birthDateStr, String gender) {
        presenter.addPerson(id, name, birthDateStr, gender);
    }

    public void displayTree() {
        presenter.displayTree();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByBirthDate() {
        presenter.sortByBirthDate();
    }

    public void saveToFile(String filename) {
        presenter.saveToFile(filename);
    }

    public void loadFromFile(String filename) {
        presenter.loadFromFile(filename);
    }

    public void removePersonById(int id) {
        presenter.removePersonById(id);
    }

    public void changePersonId(int oldId, int newId) {
        presenter.changePersonId(oldId, newId);
    }

    public void setParentChildRelation(int parentId, int childId) {
        presenter.setParentChildRelation(parentId, childId);
    }
}
