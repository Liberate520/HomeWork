package ru.gb.family.model.familyTree;

import ru.gb.family.model.familyTree.ItemFamilyTrees.ItemFamilyTree;

import java.util.Iterator;
import java.util.List;

public class ItemFamilyTreeIterator<T extends ItemFamilyTree<T>> implements Iterator<T> {
    private int curID = 0;
    private List<T> familyTree;

    public ItemFamilyTreeIterator(List<T> familyTree) {
        this.familyTree = familyTree;
    }


    @Override

    public boolean hasNext() {

        if (familyTree != null) {
            return familyTree.size() > curID;
        } else {
            return false;
        }
    }

    @Override
    public T next() {
        return familyTree.get(curID++);
    }

}
