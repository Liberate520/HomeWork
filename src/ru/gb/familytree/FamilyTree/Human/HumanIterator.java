package ru.gb.familytree.FamilyTree.Human;

import java.util.List;

public class HumanIterator<T extends FamilyTreeItem> implements Iterator<T>{
    private int curIndex;
    private List<T> relatives;

    public HumanIterator(List<T> relatives) {
        this.relatives = relatives;
    }

    @Override
    public boolean hasNext() {
        return relatives.size() > curIndex;
    }

    @Override
    public T next() {
        return relatives.get(curIndex++);
    }
}
