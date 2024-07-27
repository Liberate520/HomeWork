package FamilyTree;

import Human.Human;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<E> implements Iterator<E> {
    private int curIndex;
    private List<E> family;

    public HumanIterator(List<E> family) {
        this.family = family;
    }

    @Override
    public boolean hasNext() {
        return family.size() > curIndex;
    }

    @Override
    public E next() {
        return family.get(curIndex++);
    }
}

