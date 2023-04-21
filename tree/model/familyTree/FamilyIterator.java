package model.familyTree;

import java.util.Iterator;
import java.util.List;

public class FamilyIterator<E> implements Iterator<E> {

    private int index;
    private List<E> humanList;

    public FamilyIterator(List<E> humanList) {
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
