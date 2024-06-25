package ru.gb.family_tree.tree;

import ru.gb.family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class FTiterator implements Iterator<Human> {
    private int index;
    private List<Human> tree;

    public FTiterator (List<Human>tree){
        this.tree=tree;
    }

    @Override
    public boolean hasNext() {
        return index < tree.size();
    }

    @Override
    public Human next() {
        return tree.get(index++);
    }
}
