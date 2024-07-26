package model.iterator;

import java.util.Iterator;
import java.util.List;

public class TreeIterator<T> implements Iterator<T> {

    private final List<T> list;
    private int index;

    public TreeIterator(List<T> list) {
        this.list = list;
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
