package family_tree.iterators;

import human.Human;

import java.util.Iterator;
import java.util.List;

public class TreeIterator<E> implements Iterator<E> {
    private int index;
    private List<E> humanList;

    public TreeIterator(List<E> humanList) {
        this.humanList = humanList;
    }

    @Override
    public boolean hasNext() {
        return index < humanList.size();
    }

    @Override
    public E next() {
        return humanList.get(index++);
    }
}
