package family__tree.family_tree;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class HumanIterator<T> implements Iterator<T> {
    private List<T> humans;

    private int currentPosition;

    public HumanIterator(List<T> humans) {
        this.humans = humans;
        this.currentPosition = 0;
    }

    @Override
    public boolean hasNext() {
        return currentPosition < humans.size();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return humans.get(currentPosition++);
    }
}
