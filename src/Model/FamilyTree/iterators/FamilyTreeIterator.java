package Model.FamilyTree.iterators;

import Model.FamilyTree.FamilyTreeItem;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T extends FamilyTreeItem<T>> implements Iterator<T> {

    private int index;
    private List<T> familyTree;

    public FamilyTreeIterator(List<T> familyTree) {
        this.familyTree = familyTree;
    }




    @Override
    public boolean hasNext() {
        return familyTree.size() > index;
    }

    @Override
    public T next() {
        return familyTree.get(index++);
    }
}
