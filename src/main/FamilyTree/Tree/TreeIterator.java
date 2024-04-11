package FamilyTree.Tree;

import FamilyTree.ItemTree.Person;

import java.util.Iterator;
import java.util.List;

public class TreeIterator<E extends Person<E>> implements Iterator<E> {
    private List<E> humanList;
    private int index;

    public TreeIterator(List<E> humanList) {
        this.humanList = humanList;
        this.index = 0;
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
