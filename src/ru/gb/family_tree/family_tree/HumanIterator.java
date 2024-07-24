package ru.gb.family_tree.family_tree;

import ru.gb.family_tree.human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<T extends FamilyTreeItem<T>> implements Iterator<T> {

    private int currentId;
    private List<T> famTree;

    public HumanIterator(List<T> famTree) {
        this.famTree = famTree;
    }

    @Override
    public boolean hasNext() {
        return currentId < famTree.size();
    }

    @Override
    public T next() {
        return famTree.get(currentId++);
    }
}
