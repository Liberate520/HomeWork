package family_tree;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<E> implements Iterator<E> {
    private int currentId;
    private List<E> humans;

    public HumanIterator(List<E> humans) {
        this.humans = humans;
    }

    @Override
    public boolean hasNext() {
        return humans.size() > currentId;
    }

    @Override
    public E next() {
        return humans.get(currentId++);
    }
}
