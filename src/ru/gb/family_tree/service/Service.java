package ru.gb.family_tree.service;

import ru.gb.family_tree.FT.*;

public class Service {
    private FamilyTree familyTree;

    public Service(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void sortByName(){
        familyTree.sortByName();
    }

    public void sortByBirthDate(){
        familyTree.sortByBirthDate();
    }
}
