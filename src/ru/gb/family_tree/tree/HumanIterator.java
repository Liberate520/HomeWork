package ru.gb.family_tree.tree;

import ru.gb.family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator implements Iterator<Human> {
    private int curId;
    private List<Human> familyTreeList;

    public HumanIterator(List<Human> familyTreeList){
        this.familyTreeList = familyTreeList;
    }
    @Override
    public boolean hasNext() {
        return familyTreeList.size() > curId;
    }

    @Override
    public Human next() {
        return familyTreeList.get(curId++ );
    }
}