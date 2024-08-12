package family_tree;

import java.util.Iterator;
import java.util.List;

import human.Human;

public class HumanIterator<T> implements Iterator<T> {
    private int curIndex;
    private List<T> humans;

    public HumanIterator(List<T> humans) {
        this.humans = humans;
        curIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return curIndex < humans.size();
    }

    @Override
    public T next() {
        return humans.get(curIndex++);
    }

}
