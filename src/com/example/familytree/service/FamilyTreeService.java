package com.example.familytree.service;

import com.example.familytree.BirthDateComparator;
import com.example.familytree.FamilyTree;
import com.example.familytree.NameComparator;
import com.example.familytree.model.Person;
import com.example.familytree.operations.FileOperations;

import java.time.format.DateTimeFormatter;

public class FamilyTreeService implements FamilyTreeOperations {
    private FamilyTree<Person> familyTree;
    private final FileOperations fileOps;
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public FamilyTreeService(FileOperations fileOps) {
        this.familyTree = new FamilyTree<>();
        this.fileOps = fileOps;
    }

    @Override
    public void addPerson(Person person) {
        familyTree.addMember(person);
    }

    @Override
    public void removePersonById(int id) {
        familyTree.removeMemberById(id);
    }

    @Override
    public void changePersonId(int oldId, int newId) {
        Person person = familyTree.findPersonById(oldId);
        if (person != null) {
            person.setId(newId);
        }
    }

    @Override
    public void setParentChildRelation(int parentId, int childId) {
        Person parent = familyTree.findPersonById(parentId);
        Person child = familyTree.findPersonById(childId);
        if (parent != null && child != null) {
            parent.addChild(child);
        }
    }

    public void saveToFile(String filename) {
        fileOps.saveToFile(filename, familyTree);
    }

    public void loadFromFile(String filename) {
        familyTree = fileOps.loadFromFile(filename);
    }

    public FamilyTree<Person> getFamilyTree() {
        return familyTree;
    }

    @Override
    public void sortByName() {
        familyTree.sortBy(new NameComparator());
    }

    @Override
    public void sortByBirthDate() {
        familyTree.sortBy(new BirthDateComparator());
    }

    public void setFamilyTree(FamilyTree<Person> familyTree) {
        this.familyTree = familyTree;
    }
}
