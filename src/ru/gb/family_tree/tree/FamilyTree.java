package ru.gb.family_tree.tree;

import ru.gb.family_tree.human.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private List<Human> tree;

    public FamilyTree(){
        tree = new ArrayList<>();
    }

    public void addHuman(Human human){
        tree.add(human);
    }

    public String getFullTree(){
        StringBuilder sb = new StringBuilder();
        sb.append("Древо: \n");
        for (Human human: tree){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
}
