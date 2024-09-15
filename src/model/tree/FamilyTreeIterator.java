package model.tree;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T extends TreeConn<T>> implements Iterator<T> {

    private List<T> list;
    private int ind;

    public FamilyTreeIterator(List<T> list){
        this.list = list;
        ind = 0;
    }

    @Override
    public boolean hasNext() {
        return ind<list.size();
    }

    @Override
    public T next() {
        return list.get(ind++);
    }
}
