package ru.gb.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {

    private List<Human> familyTree;

    public FamilyTree(){
       familyTree = new ArrayList<>();
    }

    public void addHuman(Human human){
        familyTree.add(human);
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Human human: familyTree ){
           stringBuilder.append(human);
        }
        return stringBuilder.toString();
    }




}
