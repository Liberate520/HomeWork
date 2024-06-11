package ru.gb.family.familyTree;

import ru.gb.family.familyTree.ItemFamilyTrees.ItemFamilyTree;

import java.util.Iterator;
import java.util.List;

public class ItemFamilyTreeIterator<T extends ItemFamilyTree<T>> implements Iterator<T> {
    private int curID;
    private List<T> familyTree;


    @Override

    public boolean hasNext() {
        return familyTree.size()>curID;
    }

    @Override
    public T next() {
        return familyTree.get(curID++);
    }
}
