package ru.gb.Family_tree.family_tree;

import ru.gb.Family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {
    private List<Human> List;
    private  int index;

    public FamilyTreeIterator(java.util.List<Human> list) {
        this.List = list;
        index = 0;
    }


    @Override
    public boolean hasNext() {
        return index < List.size();
    }

    @Override
    public Human next() {
        return List.get(index++);
    }








}