package ru.gb.family_tree.service;

import ru.gb.family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {

    private int index;
    private List<Human> familyTree;


    public HumanIterator(List<Human> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public boolean hasNext() {
        return index < familyTree.size();
    }

    @Override
    public Human next(){
        return familyTree.get(index++);
    }

}
