package com.example.familytree.mvp;


import com.example.familytree.FamilyTree;
import com.example.familytree.model.Person;

public interface FamilyTreePresenter {
    void addPerson(int id, String name, String birthDateStr, String gender);
    void displayTree();
    void sortByName();
    void sortByBirthDate();
    void saveToFile(String filename);
    void loadFromFile(String filename);
    void removePersonById(int id);
    void changePersonId(int oldId, int newId);
    void setParentChildRelation(int parentId, int childId);

    void setFamilyTree(FamilyTree<Person> familyTree);

}
