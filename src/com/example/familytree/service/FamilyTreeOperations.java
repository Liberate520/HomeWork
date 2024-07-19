package com.example.familytree.service;

import com.example.familytree.model.Person;

public interface FamilyTreeOperations {
    void addPerson(Person person);
    void removePersonById(int id);
    void changePersonId(int oldId, int newId);
    void setParentChildRelation(int parentId, int childId);

    void sortByName();

    void sortByBirthDate();
}
