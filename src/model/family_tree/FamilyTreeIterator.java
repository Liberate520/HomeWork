package model.family_tree;

import java.util.Iterator;
import java.util.List;


public class FamilyTreeIterator<T extends TreeNode<T>> implements Iterator<T> {
    private List<T> list;
    private int index;

    public FamilyTreeIterator(List<T> humans){
        this.list = humans;
        index = 0;
    }
    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public T next() {
        return list.get(index++);
    }
}
