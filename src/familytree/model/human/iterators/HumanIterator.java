package familytree.model.human.iterators;

import familytree.model.familytree.FamilyTreeElement;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<T extends FamilyTreeElement<T>> implements Iterator<T> {
    private int index;
    private List<T> list;

    public HumanIterator(List<T> list) {
        this.list = list;
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
