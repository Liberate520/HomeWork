package Model;

import java.util.Iterator;
import java.util.List;

public class HumanIterator<T extends Human> implements Iterator<T> {
    private int curIndex;
    private List<T> human;

    public HumanIterator(List<T> human) {
        this.human = human;
    }

    public boolean hasNext() {
        return human.size() > curIndex;
    }

    public T next() {
        return human.get(curIndex++);
    }

}
