package ru.gb.family_tree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {

    private List<Human> familyTree;

    public FamilyTree(){
       familyTree = new ArrayList<>();
    }

    public void addHuman(Human human){
        familyTree.add(human);
    }



}
