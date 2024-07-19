package com.example.familytree.service;

import com.example.familytree.FamilyTree;
import com.example.familytree.model.Person;
import com.example.familytree.operations.FileOperations;

public class FamilyTreeService {
    private FamilyTree<Person> familyTree;
    private final FileOperations fileOps;

    public FamilyTreeService(FileOperations fileOps) {
        this.familyTree = new FamilyTree<>();
        this.fileOps = fileOps;
    }

    public void addPerson(Person person) {
        familyTree.addMember(person);
    }

    public void removePersonById(int id) {
        familyTree.removeMemberById(id);
    }

    public void changePersonId(int oldId, int newId) {
        Person person = familyTree.findPersonById(oldId);
        if (person != null) {
            person.setId(newId);
        }
    }

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
}
