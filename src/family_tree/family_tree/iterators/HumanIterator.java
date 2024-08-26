package family_tree.family_tree.iterators;

import java.util.Iterator;
import java.util.List;

public class HumanIterator <E>implements Iterator<E> {
    private int index;

    public HumanIterator(int index, List<E> humanList) {
        this.index = index;
        this.humanList = humanList;
    }

    private List<E> humanList;


    @Override
    public boolean hasNext() {
        return index<humanList.size();
    }

    @Override
    public E next() {
        return humanList.get(index++);
    }
}
