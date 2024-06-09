package ru.gb.family_tree.service;

import ru.gb.family_tree.tree.FamilyTree;

public class Service {
    private FamilyTree familyTreeList;

    public Service(){
        familyTreeList = new FamilyTree();
    }

    public void sortByFirstName(){
        familyTreeList.sortByFirstName();
    }

    public void sortById(){
        familyTreeList.sortById();
    }

    public void sortByGender(){
        familyTreeList.sortByGender();
    }

    public void sortByDob(){
        familyTreeList.sortByDob();
    }

    public void sortByDod(){
        familyTreeList.sortByDod();
    }
}
