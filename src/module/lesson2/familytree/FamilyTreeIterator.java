package module.lesson2.familytree;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<E extends Creature> implements Iterator<E> {
    private int index;
    private List<E> list;

    public FamilyTreeIterator(List<E> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return index < list.size();
    }

    @Override
    public E next() {
        return list.get(index++);
    }
}
