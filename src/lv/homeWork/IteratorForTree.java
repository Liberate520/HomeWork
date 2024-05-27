package lv.homeWork;

import java.util.Iterator;
import java.util.List;

public class IteratorForTree<E extends Human> implements Iterator<Human> {
    private final List<E> humanList;
    private int index;

    public IteratorForTree(List<E> humanList) {
        this.humanList = humanList;
        index = 0;
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
