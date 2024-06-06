package ru.gb.family_tree.service;

import ru.gb.family_tree.FT.*;
import ru.gb.family_tree.Human.Human;

public class Service {
    private FamilyTree<Human> familyTree;

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
