package ru.gb.familytree.FamilyTree.Human;

import java.util.List;

public class HumanIterator implements Iterator<Human>{
    private int curIndex;
    private List<Human> relatives;

    public HumanIterator(List<Human> relatives) {
        this.relatives = relatives;
    }

    @Override
    public boolean hasNext() {
        return relatives.size() > curIndex;
    }

    @Override
    public Human next() {
        return relatives.get(curIndex++);
    }
}
